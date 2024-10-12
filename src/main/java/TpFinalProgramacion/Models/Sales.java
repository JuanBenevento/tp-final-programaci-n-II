package TpFinalProgramacion.Models;

import java.util.Date;
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
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSale;
    @ManyToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicles vehicle;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customers customer;
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employees employee;
    private Date dateSale;
    private Double price;


}
