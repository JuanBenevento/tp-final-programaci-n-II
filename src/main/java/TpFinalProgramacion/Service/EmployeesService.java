package TpFinalProgramacion.Service;

import TpFinalProgramacion.DTOs.EmployeesDTO;
import TpFinalProgramacion.Models.Position;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeesService {
    List<EmployeesDTO> findAll();

    EmployeesDTO getEmployeeById(int id);

    ResponseEntity<Object> createEmployee(String name, String email, Position position);

    ResponseEntity<Object> deleteEmployee(int id);
}
