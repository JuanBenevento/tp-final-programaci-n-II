package TpFinalProgramacion.Repositories;

import TpFinalProgramacion.DTOs.PositionDTO;
import TpFinalProgramacion.Models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PositionRepository  extends JpaRepository<Position, Integer> {
    PositionDTO getPositionById(int id);
}
