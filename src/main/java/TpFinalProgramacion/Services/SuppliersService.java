package TpFinalProgramacion.Services;

import TpFinalProgramacion.DTOs.SupplierDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
public interface SuppliersService {
    List<SupplierDTO> findAll();
    SupplierDTO getSupplierById(int id);
    ResponseEntity<Object> createSupplier(String name, String email, Integer phoneNumber);
    ResponseEntity<Object> deleteSupplier(int id);

}

