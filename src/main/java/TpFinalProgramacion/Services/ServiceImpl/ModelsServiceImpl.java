package TpFinalProgramacion.Services.ServiceImpl;

import TpFinalProgramacion.DTOs.ModelDTO;
import TpFinalProgramacion.DTOs.SupplierDTO;
import TpFinalProgramacion.Models.Brands;
import TpFinalProgramacion.Models.Models;
import TpFinalProgramacion.Models.Suppliers;
import TpFinalProgramacion.Repositories.ModelsRepository;
import TpFinalProgramacion.Services.ModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ModelsServiceImpl implements ModelsService {
   @Autowired
    ModelsRepository modelsRepository;

    List<ModelDTO> findAll(){
        return modelsRepository.findAll().stream().map(model -> new ModelDTO(model)).collect(Collectors.toList());
    };
    ModelDTO getModelById(Long id){
        return modelsRepository.findById(id).map(ModelDTO::new).orElse(null);
    };


    @Override
    public ResponseEntity<Object> createModel(String description, Brands brand) {
        if (description == null || brand == null) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Models model = new Models();
        model.setDescripcion(description);
        model.setBrand(brand);

        try {
            modelsRepository.save(model);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error creating Model", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Model created successfully", HttpStatus.CREATED);    }

    @Override
    public ResponseEntity<Object> deleteModel(Long id) {
        try {
            Models modelFind = modelsRepository.findById(id).orElse(null);
            if (modelFind == null) {
                return new ResponseEntity<>("Model not found", HttpStatus.NOT_FOUND);
            }
            modelsRepository.delete(modelFind);
            return new ResponseEntity<>("Model deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error deleting Model", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
