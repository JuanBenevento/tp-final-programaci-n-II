package TpFinalProgramacion.Services.ServiceImpl;

import TpFinalProgramacion.DTOs.TypeVehicleDTO;
import TpFinalProgramacion.Models.TypesVehicles;
import TpFinalProgramacion.Repositories.TypeVehiclesRepository;
import TpFinalProgramacion.Services.TypeVehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeVehicleServiceImpl implements TypeVehiclesService {

        @Autowired
        private TypeVehiclesRepository typeVehiclesRepository;
        @Override
        public List<TypeVehicleDTO> findAll() {
            return typeVehiclesRepository.findAll().stream().map(type -> new TypeVehicleDTO(type)).collect(Collectors.toList());

        }

    @Override
        public TypeVehicleDTO getTypeById(int id) {
            return typeVehiclesRepository.findById(id).map(TypeVehicleDTO::new).orElse(null);
        }


        @Override
        public ResponseEntity<Object> createTypeVehicle(String description) {
            if (description == null || description.isEmpty()) {
                return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
            }

            TypesVehicles type = new TypesVehicles();
            type.setDescription(description);

            try {
                typeVehiclesRepository.save(type);
            } catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
                return new ResponseEntity<>("Error creating type vehicle", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>("type vehicle created successfully", HttpStatus.CREATED);    }

        @Override
        public ResponseEntity<Object> deleteType(int id) {
            try {
                TypesVehicles typeFind = typeVehiclesRepository.findById(id).orElse(null);
                if (typeFind == null) {
                    return new ResponseEntity<>("Brand not found", HttpStatus.NOT_FOUND);
                }
                typeVehiclesRepository.delete(typeFind);
                return new ResponseEntity<>("Brand deleted successfully", HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
                return new ResponseEntity<>("Error deleting Brand", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


}
