package TpFinalProgramacion.Models;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Models {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModel;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brands brand;

}
