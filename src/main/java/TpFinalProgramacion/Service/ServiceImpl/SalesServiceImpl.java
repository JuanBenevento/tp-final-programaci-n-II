package TpFinalProgramacion.Service.ServiceImpl;


import TpFinalProgramacion.DTOs.SalesDTO;
import TpFinalProgramacion.Models.Customers;
import TpFinalProgramacion.Models.Employees;
import TpFinalProgramacion.Models.Sales;
import TpFinalProgramacion.Models.Vehicles;
import TpFinalProgramacion.Repositories.SalesRepository;
import TpFinalProgramacion.Service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesRepository salesRepository;
    @Override
    public List<SalesDTO> findAll() {
        return salesRepository.findAll().stream().map(sale -> new SalesDTO(sale)).collect(Collectors.toList());
    }

    @Override
    public SalesDTO getSaleById(int id) {
        return salesRepository.findById(id).map(SalesDTO::new).orElse(null);
    }

    @Override
    public ResponseEntity<Object> createSale(Vehicles vehicle, Customers customer, Employees employee, Date dateSale, Double price) {
        if (vehicle == null || customer == null || employee == null || dateSale == null || price == null  ) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Sales sales = new Sales();
        sales.setVehicle(vehicle);
        sales.setCustomer(customer);
        sales.setEmployee(employee);
        sales.setDateSale(dateSale);
        sales.setPrice(price);


        try {
            salesRepository.save(sales);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error creating sale", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Sale created successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> deleteSale(int id) {
        try {
            Sales saleFind = salesRepository.findById(id).orElse(null);
            if (saleFind == null) {
                return new ResponseEntity<>("Sale not found", HttpStatus.NOT_FOUND);
            }
            salesRepository.delete(saleFind);
            return new ResponseEntity<>("Sale deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Error deleting sale", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
