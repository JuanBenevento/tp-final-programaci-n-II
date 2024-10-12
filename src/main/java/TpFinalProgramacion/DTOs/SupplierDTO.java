package TpFinalProgramacion.DTOs;

import TpFinalProgramacion.Models.Suppliers;

public class SupplierDTO {
    private int idSupplier;
    private String name;
    private String email;
    private int phoneNumber;

    public SupplierDTO(int idSupplier, String name, String email, int phoneNumber) {
        this.idSupplier = idSupplier;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public SupplierDTO(Suppliers sup){
        this.idSupplier  = sup.getIdSupplier();
        this.name = sup.getName();
        this.email = sup.getEmail();
        this.phoneNumber = sup.getPhoneNumber();
    }
}
