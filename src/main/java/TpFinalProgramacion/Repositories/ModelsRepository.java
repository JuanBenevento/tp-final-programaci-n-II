package TpFinalProgramacion.Repositories;

import TpFinalProgramacion.DTOs.ModelDTO;
import TpFinalProgramacion.Models.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ModelsRepository  extends JpaRepository<Models, Long> {
    ModelDTO getModelById(Long id);
}
