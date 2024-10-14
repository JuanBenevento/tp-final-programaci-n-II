package TpFinalProgramacion.Controllers;

import TpFinalProgramacion.DTOs.ModelDTO;
import TpFinalProgramacion.Models.Brands;
import TpFinalProgramacion.Models.Models;
import TpFinalProgramacion.Models.Sales;
import TpFinalProgramacion.Repositories.ModelsRepository;
import TpFinalProgramacion.Repositories.TypeVehiclesRepository;
import TpFinalProgramacion.Services.ModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles/models")
public class ModelsController {
    private final ModelsRepository modelsRepository;
    @Autowired
    ModelsService modelsService;
    public ModelsController(ModelsRepository modelsRepository) {

        this.modelsRepository = modelsRepository;
    }


    @GetMapping("")
    public List<Models> getAllModels() {
        return modelsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getModelById(@PathVariable Long id) {
        try {
            ModelDTO model =  modelsRepository.getModelById(id);
            if (model != null) {
                return new ResponseEntity<>(model, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> saveModel(
            @RequestParam String description, @RequestParam Brands brand){
        try{
            modelsService.createModel(description, brand);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteModel(@PathVariable Long id){
        try{
            modelsService.deleteModel(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error deleting model", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
