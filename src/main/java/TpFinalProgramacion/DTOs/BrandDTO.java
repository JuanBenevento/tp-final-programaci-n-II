package TpFinalProgramacion.DTOs;

import TpFinalProgramacion.Models.Brands;

public class BrandDTO {
    private int idBrand;
    private String name;

    public BrandDTO(int idBrand, String name) {
        this.idBrand = idBrand;
        this.name = name;
    }

    public BrandDTO (Brands brand){
        this.idBrand = brand.getIdBrand();
        this.name = brand.getName();
        this.name = brand.getName();
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
