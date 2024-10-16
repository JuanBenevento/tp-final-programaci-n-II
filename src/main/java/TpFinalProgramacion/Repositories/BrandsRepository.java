package TpFinalProgramacion.Repositories;

import TpFinalProgramacion.DTOs.BrandDTO;
import TpFinalProgramacion.Models.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BrandsRepository  extends JpaRepository<Brands, Integer> {
    BrandDTO getBrandByIdBrand(int id);
}
