package TpFinalProgramacion.DTOs;

import TpFinalProgramacion.Models.Position;

public class PositionDTO {
    private int idPosition;
    private String description;

    public PositionDTO(int idPosition, String description) {
        this.idPosition = idPosition;
        this.description = description;
    }

    public PositionDTO (Position position){
        this.idPosition = position.getIdPosition();
        this.description = position.getDescription();
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
