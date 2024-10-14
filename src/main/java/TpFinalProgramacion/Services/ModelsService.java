package TpFinalProgramacion.Services;

import TpFinalProgramacion.Models.Brands;
import org.springframework.http.ResponseEntity;

public interface ModelsService {
    ResponseEntity<Object> createModel(String description, Brands brand);
    ResponseEntity<Object>  deleteModel(Long id);
}
