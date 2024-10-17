package TpFinalProgramacion.Controllers;


import TpFinalProgramacion.DTOs.EmployeesDTO;
import TpFinalProgramacion.Models.Employees;
import TpFinalProgramacion.Models.Position;
import TpFinalProgramacion.Repositories.EmployeesRepository;
import TpFinalProgramacion.Service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    private final EmployeesRepository employeesRepository;
    @Autowired
    private EmployeesService employeesService;

    public EmployeesController (EmployeesRepository employeesRepository){
        this.employeesRepository = employeesRepository;
    }

    @GetMapping("")
    public List<Employees> getAllEmployees(){
        return employeesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployeesById(@PathVariable int id){
        try {
            EmployeesDTO employee =  employeesRepository.getEmployeesById(id);
            if (employee != null) {
                return new ResponseEntity<>(employee, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> saveEmployee(
            @RequestParam String name, String email, Position position){
        try{
            employeesService.createEmployee(name, email, position);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable int id){
        try{
            employeesService.deleteEmployee(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error deleting employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
