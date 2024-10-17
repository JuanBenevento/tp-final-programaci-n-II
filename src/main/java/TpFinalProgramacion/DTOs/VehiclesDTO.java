package TpFinalProgramacion.DTOs;

import TpFinalProgramacion.Models.*;


public class VehiclesDTO {
    private int idVehicle;
    private TypesVehicles typeVehicle;
    private Brands brand;
    private Models model;
    private Double price;
    private Suppliers supplier;
    private Integer stock;

    public VehiclesDTO(int idVehicle, TypesVehicles typeVehicle, Brands brand, Double price, Models model, Suppliers supplier, Integer stock) {
        this.idVehicle = idVehicle;
        this.typeVehicle = typeVehicle;
        this.brand = brand;
        this.price = price;
        this.model = model;
        this.supplier = supplier;
        this.stock = stock;
    }

    public VehiclesDTO (Vehicles vehicles){
        this.idVehicle = vehicles.getIdVehicle();
        this.typeVehicle = vehicles.getTypeVehicle();
        this.brand = vehicles.getBrand();
        this.price = vehicles.getPrice();
        this.model = vehicles.getModel();
        this.supplier = vehicles.getSupplier();
        this.stock = vehicles.getStock();
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public TypesVehicles getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(TypesVehicles typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public Models getModel() {
        return model;
    }

    public void setModel(Models model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
