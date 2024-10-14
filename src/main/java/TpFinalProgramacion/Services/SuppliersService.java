package TpFinalProgramacion.Services;

import TpFinalProgramacion.DTOs.SupplierDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface SuppliersService {
    List<SupplierDTO> findAll();
    SupplierDTO getSupplierById(Long id);
    ResponseEntity<Object> createSupplier(String name, String email, Integer phoneNumber);
    ResponseEntity<Object> deleteSupplier(Long id);

}

