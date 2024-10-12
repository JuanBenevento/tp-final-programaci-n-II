package TpFinalProgramacion.DTOs;

import TpFinalProgramacion.Models.TypesVehicles;

public class TypeVehicleDTO {
    private int idType;
    private String description;

    public TypeVehicleDTO(int idType, String description) {
        this.idType = idType;
        this.description = description;
    }

    public  TypeVehicleDTO(TypesVehicles type){
        this.idType = type.getIdType();
        this.description = type.getDescription();
    }
}
