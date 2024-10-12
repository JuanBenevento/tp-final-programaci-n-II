package TpFinalProgramacion.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVehicle;
    // relacion con TypeVehicle
    private int idTypeVehicle;
    // relacion con Brands
    private int idBrand;
    // relacion con Models
    private int idModel;
    private Double price;
    // relacion con Suppliers
    private int idSupplier;
    private int stock;


}
