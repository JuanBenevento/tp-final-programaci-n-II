package TpFinalProgramacion.DTOs;

import TpFinalProgramacion.Models.Customers;

public class CustomersDTO {
    private int idCustomer;
    private String name;
    private String email;
    private String lastname;

    public CustomersDTO(int idCustomer, String name, String email, String lastname) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.email = email;
        this.lastname = lastname;
    }

    public CustomersDTO(Customers customer){

        this.idCustomer = customer.getIdCustomer();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.lastname = customer.getLastname();
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
