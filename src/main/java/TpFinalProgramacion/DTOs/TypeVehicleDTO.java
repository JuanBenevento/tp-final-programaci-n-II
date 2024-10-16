package TpFinalProgramacion.DTOs;

import TpFinalProgramacion.Models.TypesVehicles;

public class TypeVehicleDTO {
    private int id;
    private String description;

    public TypeVehicleDTO(int idType, String description) {
        this.id = idType;
        this.description = description;
    }

    public  TypeVehicleDTO(TypesVehicles type){
        this.id = type.getId();
        this.description = type.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int idType) {
        this.id = idType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
