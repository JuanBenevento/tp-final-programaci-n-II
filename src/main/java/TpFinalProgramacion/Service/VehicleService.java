package TpFinalProgramacion.Service;

import TpFinalProgramacion.DTOs.VehiclesDTO;
import TpFinalProgramacion.Models.Brands;
import TpFinalProgramacion.Models.Models;
import TpFinalProgramacion.Models.Suppliers;
import TpFinalProgramacion.Models.TypesVehicles;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleService {
    List<VehiclesDTO> findAll();

    VehiclesDTO getVehicleById(int id);

    ResponseEntity<Object> createVehicle(TypesVehicles typesVehicle, Brands brand, Models model, Double price, Suppliers supplier, Integer stock);

    ResponseEntity<Object> deleteVehicle(int id);
}
