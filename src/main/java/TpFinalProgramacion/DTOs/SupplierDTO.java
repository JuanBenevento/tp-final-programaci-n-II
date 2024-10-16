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
        this.idSupplier  = sup.getId();
        this.name = sup.getName();
        this.email = sup.getEmail();
        this.phoneNumber = sup.getPhoneNumber();
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
