package TpFinalProgramacion.Service.ServiceImpl;

import TpFinalProgramacion.DTOs.EmployeesDTO;
import TpFinalProgramacion.Models.Employees;
import TpFinalProgramacion.Models.Position;
import TpFinalProgramacion.Repositories.EmployeesRepository;
import TpFinalProgramacion.Service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;
    @Override
    public List<EmployeesDTO> findAll() {
        return employeesRepository.findAll().stream().map(employee -> new EmployeesDTO(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeesDTO getEmployeeById(int id) {
        return employeesRepository.findById(id).map(EmployeesDTO::new).orElse(null);
    }

    @Override
    public ResponseEntity<Object> createEmployee(String name, String email, Position position) {
        if (name == null || name.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        if (email == null || email.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        if (position == null) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }


        Employees employees = new Employees();
        employees.setName(name);
        employees.setEmail(email);
        employees.setPosition(position);

        try {
            employeesRepository.save(employees);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error creating employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Employee created successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> deleteEmployee(int id) {
        try {
            Employees employeeFind = employeesRepository.findById(id).orElse(null);
            if (employeeFind == null) {
                return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
            }
            employeesRepository.delete(employeeFind);
            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error deleting employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
