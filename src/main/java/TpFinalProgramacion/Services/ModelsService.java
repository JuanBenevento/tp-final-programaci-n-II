package TpFinalProgramacion.Services;

import TpFinalProgramacion.Models.Brands;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface ModelsService {
    ResponseEntity<Object> createModel(String description, Brands brand);
    ResponseEntity<Object>  deleteModel(int id);
}
