package TpFinalProgramacion.Controllers;

import TpFinalProgramacion.DTOs.SalesDTO;
import TpFinalProgramacion.Models.*;
import TpFinalProgramacion.Repositories.SalesRepository;
import TpFinalProgramacion.Service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    private final SalesRepository salesRepository;
    @Autowired
    private SalesService salesService;

    public SalesController(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @GetMapping("")
    public List<Sales> getAllSales(){
        return salesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSalesById(@PathVariable int id){
        try {
            SalesDTO sale =  salesRepository.getSaleById(id);
            if (sale != null) {
                return new ResponseEntity<>(sale, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> saveSales(
            @RequestParam Vehicles vehicle, Customers customer, Employees employee, Date dateSale, Double price){
        try{
            salesService.createSale(vehicle, customer, employee, dateSale, price);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSale(@PathVariable int id){
        try{
            salesService.deleteSale(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error deleting sale", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
