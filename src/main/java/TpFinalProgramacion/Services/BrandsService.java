package TpFinalProgramacion.Services;

import TpFinalProgramacion.DTOs.BrandDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
public interface BrandsService {
    List<BrandDTO> findAll();

    BrandDTO getBrandByIdBrand(int id);

    ResponseEntity<Object> createBrand(String name);

    ResponseEntity<Object> deleteBrand(int id);
}
