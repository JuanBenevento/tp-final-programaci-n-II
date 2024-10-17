package TpFinalProgramacion.Service.ServiceImpl;


import TpFinalProgramacion.DTOs.VehiclesDTO;
import TpFinalProgramacion.Models.*;
import TpFinalProgramacion.Repositories.VehiclesRepository;
import TpFinalProgramacion.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehiclesRepository vehiclesRepository;
    @Override
    public List<VehiclesDTO> findAll() {
        return vehiclesRepository.findAll().stream().map(vehicle -> new VehiclesDTO(vehicle)).collect(Collectors.toList());
    }

    @Override
    public VehiclesDTO getVehicleById(int id) {
        return vehiclesRepository.findById(id).map(VehiclesDTO::new).orElse(null);
    }

    @Override
    public ResponseEntity<Object> createVehicle(TypesVehicles typesVehicle, Brands brand, Models model, Double price, Suppliers supplier, Integer stock) {
        if (typesVehicle == null || brand == null || model == null || price == null || supplier == null || stock == null) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }


        Vehicles vehicles = new Vehicles();
        vehicles.setTypeVehicle(typesVehicle);
        vehicles.setBrand(brand);
        vehicles.setModel(model);
        vehicles.setPrice(price);
        vehicles.setSupplier(supplier);
        vehicles.setStock(stock);

        try {
            vehiclesRepository.save(vehicles);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error creating vehicle", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Vehicle created successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> deleteVehicle(int id) {
        try {
            Vehicles vehicleFind = vehiclesRepository.findById(id).orElse(null);
            if (vehicleFind == null) {
                return new ResponseEntity<>("Vehicle not found", HttpStatus.NOT_FOUND);
            }
            vehiclesRepository.delete(vehicleFind);
            return new ResponseEntity<>("Vehicle deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error deleting Vehicle", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
