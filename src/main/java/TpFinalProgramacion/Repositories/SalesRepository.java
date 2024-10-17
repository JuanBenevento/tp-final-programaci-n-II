package TpFinalProgramacion.Repositories;

import TpFinalProgramacion.DTOs.SalesDTO;
import TpFinalProgramacion.Models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalesRepository  extends JpaRepository<Sales, Integer> {
    SalesDTO getSaleById(int id);
}
