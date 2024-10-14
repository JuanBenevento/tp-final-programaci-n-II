package TpFinalProgramacion.Repositories;

import TpFinalProgramacion.DTOs.SupplierDTO;
import TpFinalProgramacion.Models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {
    SupplierDTO getSupplierById(Long id);
}
