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
@RequestMapping("/typesVehicles")
public class TypeVehicleController {

    private final TypeVehiclesRepository typeVehiclesRepository;

    @Autowired
    private TypeVehiclesService typeVehiclesService;

    public TypeVehicleController(TypeVehiclesRepository typeVehiclesRepository) {

        this.typeVehiclesRepository = typeVehiclesRepository;
    }


    @GetMapping("")
    public List<TypeVehicleDTO> getAllTypes() {
        return typeVehiclesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTypeById(@PathVariable int id) {
        try {
            TypeVehicleDTO typeVehicle =  typeVehiclesService.getTypeById(id);
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
            typeVehiclesService.createTypeVehicle(description);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deteleType(@PathVariable int id){
        try{
            typeVehiclesService.deleteType(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error deleting type of vehicle", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
