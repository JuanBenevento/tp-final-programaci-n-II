package TpFinalProgramacion.DTOs;

import TpFinalProgramacion.Models.Customers;
import TpFinalProgramacion.Models.Employees;
import TpFinalProgramacion.Models.Sales;
import TpFinalProgramacion.Models.Vehicles;

import java.util.Date;

public class SalesDTO {
    private int idSale;
    private Vehicles vehicle;
    private Customers customer;
    private Employees employee;
    private Date dateSale;
    private Double price;


    public SalesDTO(int idSale, Employees employee, Vehicles vehicle, Customers customer, Date dateSale, Double price) {
        this.idSale = idSale;
        this.employee = employee;
        this.vehicle = vehicle;
        this.customer = customer;
        this.dateSale = dateSale;
        this.price = price;
    }

    public  SalesDTO (Sales sales){
        this.idSale = sales.getIdSale();
        this.employee = sales.getEmployee();
        this.vehicle = sales.getVehicle();
        this.customer = sales.getCustomer();
        this.dateSale = sales.getDateSale();
        this.price = sales.getPrice();
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
