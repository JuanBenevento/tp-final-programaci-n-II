package TpFinalProgramacion.Controllers;

import TpFinalProgramacion.DTOs.SupplierDTO;
import TpFinalProgramacion.Models.Suppliers;
import TpFinalProgramacion.Repositories.SuppliersRepository;
import TpFinalProgramacion.Services.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    private final SuppliersRepository suppliersRepository;
    @Autowired
    private SuppliersService suppliersService;
    public SuppliersController(SuppliersRepository suppliersRepository) {

        this.suppliersRepository = suppliersRepository;
    }


    @GetMapping("")
    public List<Suppliers> getAllSuppliers() {
        return suppliersRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSupplierById(@PathVariable int id) {
        try {
            SupplierDTO supplier =  suppliersRepository.getSupplierById(id);
            if (supplier != null) {
                return new ResponseEntity<>(supplier, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> saveSupplier(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam Integer phoneNumber){
        try{
            suppliersService.createSupplier(name, email,phoneNumber);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSupplier(@PathVariable int id){
        try{
            suppliersService.deleteSupplier(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error deleting user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
