package com.example.personabeachpark.employees.types;

import com.example.personabeachpark.employees.Employee;
import com.example.personabeachpark.employees.occupation.EmployeeOccupation;

public class ActivitiesTeamMember extends Employee {
    public ActivitiesTeamMember() {
        super();
        super.setOccupationType(EmployeeOccupation.ACTIVITIES);
    }

    public void addEquipment(String name, int quantity){

    }

    public void removeEquipment(String name){

    }

    public void decreaseEquipment(String name, int quantity){

    }

    public void logEquipments(){

    }
}
