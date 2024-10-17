package TpFinalProgramacion.Service;


import TpFinalProgramacion.DTOs.PositionDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PositionService {
    List<PositionDTO> findAll();

    PositionDTO getPositionById(int id);

    ResponseEntity<Object> createPosition(String description);

    ResponseEntity<Object> deletePosition(int id);
}
