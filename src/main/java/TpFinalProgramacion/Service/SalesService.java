package TpFinalProgramacion.Service;

import TpFinalProgramacion.DTOs.SalesDTO;
import TpFinalProgramacion.Models.Customers;
import TpFinalProgramacion.Models.Employees;
import TpFinalProgramacion.Models.Vehicles;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface SalesService {
    List<SalesDTO> findAll();

    SalesDTO getSaleById(int id);

    ResponseEntity<Object> createSale(Vehicles vehicle, Customers customer, Employees employee, Date dateSale, Double price);

    ResponseEntity<Object> deleteSale(int id);
}
