package TpFinalProgramacion.DTOs;

import TpFinalProgramacion.Models.Brands;
import TpFinalProgramacion.Models.Models;

public class ModelDTO {
    private int idModel;
    private Brands brand;

    public ModelDTO(int idModel, Brands brand) {
        this.idModel = idModel;
        this.brand = brand;
    }

    public ModelDTO(Models model){
        this.idModel = model.getIdModel();
        this.brand = model.getBrand();
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }
}
