package TpFinalProgramacion.Repositories;

import TpFinalProgramacion.DTOs.TypeVehicleDTO;
import TpFinalProgramacion.Models.TypesVehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;

@RepositoryRestResource
public interface TypeVehiclesRepository extends JpaRepository<TypesVehicles, Integer> {
}
