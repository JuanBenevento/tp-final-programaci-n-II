package TpFinalProgramacion.Service.ServiceImpl;


import TpFinalProgramacion.DTOs.PositionDTO;
import TpFinalProgramacion.Models.Position;
import TpFinalProgramacion.Repositories.PositionRepository;
import TpFinalProgramacion.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.sun.beans.introspect.PropertyInfo.Name.description;

public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<PositionDTO> findAll() {
        return positionRepository.findAll().stream().map(position -> new PositionDTO(position)).collect(Collectors.toList());
    }

    @Override
    public PositionDTO getPositionById(int id) {
        return positionRepository.findById(id).map(PositionDTO::new).orElse(null);
    }

    @Override
    public ResponseEntity<Object> createPosition(String description) {
        if (description == null || description.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Position position = new Position();
        position.setDescription(description);

        try {
            positionRepository.save(position);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error creating position", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Position created successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> deletePosition(int id) {
        try {
            Position positionFind = positionRepository.findById(id).orElse(null);
            if (positionFind == null) {
                return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
            }
            positionRepository.delete(positionFind);
            return new ResponseEntity<>("Position deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error deleting position", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
