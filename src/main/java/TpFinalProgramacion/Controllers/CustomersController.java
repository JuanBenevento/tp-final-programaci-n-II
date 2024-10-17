package TpFinalProgramacion.Controllers;

import TpFinalProgramacion.DTOs.CustomersDTO;
import TpFinalProgramacion.Models.Customers;
import TpFinalProgramacion.Repositories.CustomersRepository;
import TpFinalProgramacion.Service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    private final CustomersRepository customersRepository;
    @Autowired
    private CustomersService customerService;

    public CustomersController(CustomersRepository customersRepository){
        this.customersRepository = customersRepository;
    }

    @GetMapping("")
    public List<Customers> getAllCustomers(){
        return customersRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable int id){
        try {
            CustomersDTO customer =  customersRepository.getCustomersById(id);
            if (customer != null) {
                return new ResponseEntity<>(customer, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> saveCustomer(
            @RequestParam String name, String email, String lastName){
        try{
            customerService.createCustomer(name, email, lastName);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int id){
        try{
            customerService.deleteCustomer(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error deleting customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
