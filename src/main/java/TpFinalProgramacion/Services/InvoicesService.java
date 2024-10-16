package TpFinalProgramacion.Services;

import TpFinalProgramacion.DTOs.InvoiceDTO;
import TpFinalProgramacion.DTOs.SupplierDTO;
import TpFinalProgramacion.Models.Sales;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
public interface InvoicesService {
    ResponseEntity<Object> createInvoice(Sales sale, Date dateInvoice, Double totalAmount);

    ResponseEntity<Object> deleteInvoice(int id);

    List<InvoiceDTO> findAll();

    InvoiceDTO getInvoiceByidInvoice(int id);
}
