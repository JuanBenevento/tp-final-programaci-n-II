package TpFinalProgramacion.Service.ServiceImpl;

import TpFinalProgramacion.DTOs.CustomersDTO;
import TpFinalProgramacion.Models.Customers;
import TpFinalProgramacion.Repositories.CustomersRepository;
import TpFinalProgramacion.Service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomersServiceImpl implements CustomersService {
    @Autowired
    private CustomersRepository customersRepository;
    @Override
    public List<CustomersDTO> findAll() {
        return customersRepository.findAll().stream().map(customer -> new CustomersDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomersDTO getCustomerById(int id) {
        return customersRepository.findById(id).map(CustomersDTO::new).orElse(null);
    }

    @Override
    public ResponseEntity<Object> createCustomer(String name, String email, String lastName) {
        if (name == null || name.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        if (email == null || email.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        if (lastName == null || lastName.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Customers customers = new Customers();
        customers.setName(name);
        customers.setEmail(email);
        customers.setLastname(lastName);

        try {
            customersRepository.save(customers);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error creating customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Customer created successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> deleteCustomer(int id) {
        try {
            Customers customerFind = customersRepository.findById(id).orElse(null);
            if (customerFind == null) {
                return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
            }
            customersRepository.delete(customerFind);
            return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error deleting Customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
