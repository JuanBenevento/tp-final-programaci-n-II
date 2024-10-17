package TpFinalProgramacion.Repositories;


import TpFinalProgramacion.DTOs.CustomersDTO;
import TpFinalProgramacion.Models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomersRepository  extends JpaRepository<Customers, Integer> {
    CustomersDTO getCustomersById(int id);
}

