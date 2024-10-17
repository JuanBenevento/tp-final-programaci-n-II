package TpFinalProgramacion.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVehicle;
    @ManyToOne
    @JoinColumn(name = "id_type")
    private TypesVehicles typeVehicle;
    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brands brand;
    @ManyToOne
    @JoinColumn(name = "id_model")
    private Models model;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Suppliers supplier;
    private Integer stock;


}
