package TpFinalProgramacion.Controllers;

import TpFinalProgramacion.DTOs.TypeVehicleDTO;
import TpFinalProgramacion.Models.TypesVehicles;
import TpFinalProgramacion.Repositories.TypeVehiclesRepository;
import TpFinalProgramacion.Services.TypeVehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles/types")
public class TypeVehicleController {
    private final TypeVehiclesRepository typeVehiclesRepository;
    @Autowired
    TypeVehiclesService typeVehiclesService;
    public TypeVehicleController(TypeVehiclesRepository typeVehiclesRepository) {

        this.typeVehiclesRepository = typeVehiclesRepository;
    }


    @GetMapping("")
    public List<TypesVehicles> getAllTypes() {
        return typeVehiclesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTypeById(@PathVariable Long id) {
        try {
            TypeVehicleDTO typeVehicle =  typeVehiclesRepository.getTypeById(id);
            if (typeVehicle != null) {
                return new ResponseEntity<>(typeVehicle, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> saveTypeVehicle(
            @RequestParam String description){
        try{
            typeVehiclesRepository.createTypeVehicle(description);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deteleType(@PathVariable Long id){
        try{
            typeVehiclesRepository.deleteType(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error deleting type of vehicle", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
