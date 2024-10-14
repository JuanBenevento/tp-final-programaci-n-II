package TpFinalProgramacion.Controllers;

import TpFinalProgramacion.DTOs.InvoiceDTO;
import TpFinalProgramacion.DTOs.SupplierDTO;
import TpFinalProgramacion.Models.Invoices;
import TpFinalProgramacion.Models.Sales;
import TpFinalProgramacion.Models.Suppliers;
import TpFinalProgramacion.Repositories.InvoicesRepository;
import TpFinalProgramacion.Repositories.SuppliersRepository;
import TpFinalProgramacion.Services.InvoicesService;
import TpFinalProgramacion.Services.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoicesController {
    private final InvoicesRepository invoicesRepository;
    @Autowired
    InvoicesService invoicesService;
    public InvoicesController(InvoicesRepository invoicesRepository) {

        this.invoicesRepository = invoicesRepository;
    }


    @GetMapping("")
    public List<Invoices> getAllInvoices() {
        return invoicesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getInvoiceById(@PathVariable Long id) {
        try {
            InvoiceDTO invoice =  invoicesRepository.getInvoiceById(id);
            if (invoice != null) {
                return new ResponseEntity<>(invoice, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("")
    public ResponseEntity<Object> saveInvoice(
            @RequestParam Sales sale,
            @RequestParam Date dateInvoice,
            @RequestParam Double totalAmount){
        try{
            invoicesService.createInvoice(sale, dateInvoice,totalAmount);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deteleInvoice(@PathVariable Long id){
        try{
            invoicesService.deleteInvoice(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error deleting invoice", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
