package TpFinalProgramacion.Services;

import TpFinalProgramacion.DTOs.BrandDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrandsService {
    List<BrandDTO> findAll();

    BrandDTO getBrandById(Long id);

    ResponseEntity<Object> createBrand(String name);

    ResponseEntity<Object> deleteBrand(Long id);
}
