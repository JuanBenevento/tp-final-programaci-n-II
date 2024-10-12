package TpFinalProgramacion.DTOs;

import TpFinalProgramacion.Models.Employees;
import TpFinalProgramacion.Models.Position;

public class EmployeesDTO {
    private int idEmployee;
    private String name;
    private String email;
    private Position position;

    public EmployeesDTO(int idEmployee, String name, String email, Position position) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.email = email;
        this.position = position;
    }

    public EmployeesDTO (Employees employees){
        this.idEmployee = employees.getIdEmployee();
        this.name = employees.getName();
        this.email = employees.getEmail();
        this.position = employees.getPosition();
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
