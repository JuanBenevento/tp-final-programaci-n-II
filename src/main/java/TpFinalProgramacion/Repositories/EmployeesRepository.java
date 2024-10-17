package TpFinalProgramacion.Repositories;


import TpFinalProgramacion.DTOs.EmployeesDTO;
import TpFinalProgramacion.Models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeesRepository  extends JpaRepository<Employees, Integer> {
    EmployeesDTO getEmployeesById (int id);
}
