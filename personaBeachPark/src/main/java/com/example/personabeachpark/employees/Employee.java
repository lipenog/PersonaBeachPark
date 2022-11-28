package com.example.personabeachpark.employees;

import com.example.personabeachpark.employees.employeeFactory.OccupationFactory;
import com.example.personabeachpark.employees.occupation.EmployeeOccupation;
import com.example.personabeachpark.employees.types.Occupation;
import com.example.personabeachpark.usersData.User;

public class Employee extends User {
    private double wage;
    private String workHours;

    private EmployeeOccupation occupationType;
    private Occupation occupation;
    private OccupationFactory occupationFactory = OccupationFactory.getInstance();

    public Employee(){

    }

    public Employee(double wage, String workHours, EmployeeOccupation occupationType) {
        this.wage = wage;
        this.workHours = workHours;
        this.occupationType = occupationType;
        occupation = occupationFactory.createOccupation(occupationType);
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public EmployeeOccupation getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(EmployeeOccupation occupationType) {
        this.occupationType = occupationType;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return  super.toString() +
                " {" +
                "wage= " + wage +
                ", workHours= '" + workHours + '\'' +
                ", occupation= '"+ occupationType + '\'' +
                '}' + "]";
    }
}
