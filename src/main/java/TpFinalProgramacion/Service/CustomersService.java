package TpFinalProgramacion.Service;

import TpFinalProgramacion.DTOs.CustomersDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomersService {
    List<CustomersDTO> findAll();

    CustomersDTO getCustomerById(int id);

    ResponseEntity<Object> createCustomer(String name, String email, String lastName);

    ResponseEntity<Object> deleteCustomer(int id);
}
