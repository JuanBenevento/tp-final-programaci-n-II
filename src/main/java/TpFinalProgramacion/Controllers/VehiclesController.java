package TpFinalProgramacion.Controllers;



import TpFinalProgramacion.DTOs.VehiclesDTO;
import TpFinalProgramacion.Models.*;
import TpFinalProgramacion.Repositories.VehiclesRepository;
import TpFinalProgramacion.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {
    private final VehiclesRepository vehiclesRepository;
    @Autowired
    private VehicleService vehicleService;

    public VehiclesController(VehiclesRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }

    @GetMapping("")
    public List<Vehicles> getAllVehicles() {
        return vehiclesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVehiclesById(@PathVariable int id) {
        try {
            VehiclesDTO vehicle = vehiclesRepository.getVehicleById(id);
            if (vehicle != null) {
                return new ResponseEntity<>(vehicle, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> saveSales(
            @RequestParam TypesVehicles typesVehicle, Brands brand, Models model, Double price, Suppliers supplier, Integer stock) {
        try {
            vehicleService.createVehicle(typesVehicle, brand, model, price, supplier, stock);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVehicle(@PathVariable int id) {
        try {
            vehicleService.deleteVehicle(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error deleting vehicle", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}