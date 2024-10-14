package TpFinalProgramacion.Controllers;

import TpFinalProgramacion.DTOs.BrandDTO;
import TpFinalProgramacion.Models.Brands;
import TpFinalProgramacion.Repositories.BrandsRepository;
import TpFinalProgramacion.Services.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vehicles/brands")
public class BrandsController {
    private final BrandsRepository brandsRepository;
    @Autowired
    BrandsService brandsService;
    public BrandsController(BrandsRepository brandsRepository) {

        this.brandsRepository = brandsRepository;
    }


    @GetMapping("")
    public List<Brands> getAllBrands() {
        return brandsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBrandById(@PathVariable Long id) {
        try {
            BrandDTO brand =  brandsRepository.getBrandById(id);
            if (brand != null) {
                return new ResponseEntity<>(brand, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("")
    public ResponseEntity<Object> saveBrand(
            @RequestParam String name){
        try{
            brandsService.createBrand(name);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBrand(@PathVariable Long id){
        try{
            brandsService.deleteBrand(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error deleting brand", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
