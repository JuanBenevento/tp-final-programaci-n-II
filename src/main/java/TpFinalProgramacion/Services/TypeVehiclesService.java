package TpFinalProgramacion.Services;

import TpFinalProgramacion.DTOs.SupplierDTO;
import TpFinalProgramacion.DTOs.TypeVehicleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TypeVehiclesService {
    List<TypeVehicleDTO> findAll();
    TypeVehicleDTO getTypeById(int id);
    ResponseEntity<Object> createTypeVehicle(String description);
    ResponseEntity<Object> deleteType(int id);
}
