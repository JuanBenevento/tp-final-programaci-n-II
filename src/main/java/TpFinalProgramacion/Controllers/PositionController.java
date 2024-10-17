package TpFinalProgramacion.Controllers;

import TpFinalProgramacion.DTOs.PositionDTO;
import TpFinalProgramacion.Models.Position;
import TpFinalProgramacion.Repositories.PositionRepository;
import TpFinalProgramacion.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {
    private final PositionRepository positionRepository;
    @Autowired
    private PositionService positionService;

    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @GetMapping("")
    public List<Position> getAllPosition(){
        return positionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPositionById(@PathVariable int id){
        try {
            PositionDTO position =  positionRepository.getPositionById(id);
            if (position != null) {
                return new ResponseEntity<>(position, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> savePosition(
            @RequestParam String description){
        try{
            positionService.createPosition(description);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePosition(@PathVariable int id){
        try{
            positionService.deletePosition(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error deleting position", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
