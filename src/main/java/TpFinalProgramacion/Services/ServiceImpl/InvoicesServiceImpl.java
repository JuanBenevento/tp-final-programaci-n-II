package TpFinalProgramacion.Services.ServiceImpl;

import TpFinalProgramacion.DTOs.InvoiceDTO;
import TpFinalProgramacion.DTOs.SupplierDTO;
import TpFinalProgramacion.Models.Invoices;
import TpFinalProgramacion.Models.Sales;
import TpFinalProgramacion.Models.Suppliers;
import TpFinalProgramacion.Repositories.InvoicesRepository;
import TpFinalProgramacion.Services.InvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class InvoicesServiceImpl implements InvoicesService {
    @Autowired
    InvoicesRepository invoicesRepository;
    @Override
    public List<InvoiceDTO> findAll() {
        return invoicesRepository.findAll().stream().map(invoice -> new InvoiceDTO(invoice)).collect(Collectors.toList());

    }

    @Override
    public InvoiceDTO getInvoiceById(Long id) {
        return invoicesRepository.findById(id).map(InvoiceDTO::new).orElse(null);
    }


    @Override
    public ResponseEntity<Object> createInvoice(Sales sale, Date dateInvoice, Double totalAmount) {
        if (sale == null || dateInvoice == null || totalAmount == null) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Invoices invoice = new Invoices();
        invoice.setSale(sale);
        invoice.setDateInvoice(dateInvoice);
        invoice.setTotalAmount(totalAmount);

        try {
            invoicesRepository.save(invoice);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error creating invoice", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Supplier created successfully", HttpStatus.CREATED);    }

    @Override
    public ResponseEntity<Object> deleteInvoice(Long id) {
        try {
            Invoices invoiceFind = invoicesRepository.findById(id).orElse(null);
            if (invoiceFind == null) {
                return new ResponseEntity<>("Invoice not found", HttpStatus.NOT_FOUND);
            }
            invoicesRepository.delete(invoiceFind);
            return new ResponseEntity<>("Invoice deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error deleting Invoice", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
