package TpFinalProgramacion.Repositories;

import TpFinalProgramacion.DTOs.InvoiceDTO;
import TpFinalProgramacion.Models.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InvoicesRepository  extends JpaRepository<Invoices, Integer> {
    InvoiceDTO getInvoiceByidInvoice(int id);
}
