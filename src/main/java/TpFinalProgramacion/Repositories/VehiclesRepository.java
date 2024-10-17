package TpFinalProgramacion.Repositories;

import TpFinalProgramacion.DTOs.VehiclesDTO;
import TpFinalProgramacion.Models.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehiclesRepository  extends JpaRepository<Vehicles, Integer> {
    VehiclesDTO getVehicleById(int id);
}
