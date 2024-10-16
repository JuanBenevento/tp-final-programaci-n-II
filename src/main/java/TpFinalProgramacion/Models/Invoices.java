package TpFinalProgramacion.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInvoice;

    @ManyToOne
    @JoinColumn(name = "id_sale")
    private Sales sale;
    private Date dateInvoice;
    private Double totalAmount;
}
