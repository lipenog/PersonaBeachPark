package com.example.personabeachpark.employees;

import com.example.personabeachpark.Facade;
import com.example.personabeachpark.employees.employeeFactory.EmployeeFactory;
import com.example.personabeachpark.employees.occupation.EmployeeOccupation;
import com.example.personabeachpark.usersData.User;

public abstract class Employee extends User {
    private double wage;
    private String workHours;
    private Facade facade;

    private EmployeeOccupation occupationType;
    private EmployeeFactory employeeFactory = EmployeeFactory.getInstance();

    public Employee(){
        facade = new Facade();
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

    public Facade getFacade() {
        return facade;
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
