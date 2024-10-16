package TpFinalProgramacion.Services.ServiceImpl;

import TpFinalProgramacion.DTOs.SupplierDTO;
import TpFinalProgramacion.Models.Suppliers;
import TpFinalProgramacion.Repositories.SuppliersRepository;
import TpFinalProgramacion.Services.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SuppliersServiceImpl implements SuppliersService {
    @Autowired
    private SuppliersRepository suppliersRepository;
    @Override
    public List<SupplierDTO> findAll() {
        return suppliersRepository.findAll().stream().map(supplier -> new SupplierDTO(supplier)).collect(Collectors.toList());

    }

    @Override
    public SupplierDTO getSupplierById(int id) {
        return suppliersRepository.findById(id).map(SupplierDTO::new).orElse(null);
    }


    @Override
    public ResponseEntity<Object> createSupplier(String name, String email, Integer phoneNumber) {
        if (name == null || email.isEmpty() || phoneNumber == null) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Suppliers supplier = new Suppliers();
        supplier.setName(name);
        supplier.setEmail(email);
        supplier.setPhoneNumber(phoneNumber);

        try {
            suppliersRepository.save(supplier);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error creating supplier", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Supplier created successfully", HttpStatus.CREATED);    }

    @Override
    public ResponseEntity<Object> deleteSupplier(int id) {
        try {
            Suppliers supplierFind = suppliersRepository.findById(id).orElse(null);
            if (supplierFind == null) {
                return new ResponseEntity<>("Supplier not found", HttpStatus.NOT_FOUND);
            }
            suppliersRepository.delete(supplierFind);
            return new ResponseEntity<>("Supplier deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error deleting Supplier", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
