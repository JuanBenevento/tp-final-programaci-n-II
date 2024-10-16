package TpFinalProgramacion.Services.ServiceImpl;

import TpFinalProgramacion.DTOs.BrandDTO;
import TpFinalProgramacion.Models.Brands;
import TpFinalProgramacion.Repositories.BrandsRepository;
import TpFinalProgramacion.Services.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BrandsServiceImpl implements BrandsService {
    @Autowired
    private BrandsRepository brandRepository;
    @Override
    public List<BrandDTO> findAll() {
        return brandRepository.findAll().stream().map(brand -> new BrandDTO(brand)).collect(Collectors.toList());

    }

    @Override
    public BrandDTO getBrandByIdBrand(int id) {
        return brandRepository.findById(id).map(BrandDTO::new).orElse(null);
    }


    @Override
    public ResponseEntity<Object> createBrand(String name) {
        if (name == null || name.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Brands brands = new Brands();
        brands.setName(name);

        try {
            brandRepository.save(brands);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error creating brand", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Brand created successfully", HttpStatus.CREATED);    }

    @Override
    public ResponseEntity<Object> deleteBrand(int id) {
        try {
            Brands brandFind = brandRepository.findById(id).orElse(null);
            if (brandFind == null) {
                return new ResponseEntity<>("Brand not found", HttpStatus.NOT_FOUND);
            }
            brandRepository.delete(brandFind);
            return new ResponseEntity<>("Brand deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error deleting Brand", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
