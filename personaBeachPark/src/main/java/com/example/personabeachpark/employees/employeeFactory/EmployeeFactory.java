package com.example.personabeachpark.employees.employeeFactory;

import com.example.personabeachpark.employees.Employee;
import com.example.personabeachpark.employees.occupation.EmployeeOccupation;
import com.example.personabeachpark.employees.types.ActivitiesTeamMember;
import com.example.personabeachpark.employees.types.AdministrationMember;
import com.example.personabeachpark.employees.types.FoodServiceMember;

public class EmployeeFactory {
    private static EmployeeFactory singleton;
    private Employee employee;
    private EmployeeFactory(){

    }

    public static EmployeeFactory getInstance(){
        if(singleton == null){
            singleton = new EmployeeFactory();
        }
        return singleton;
    }

    public Employee createOccupation(EmployeeOccupation type){
        if(type == EmployeeOccupation.ACTIVITIES){
            employee = new ActivitiesTeamMember();
        } else if (type == EmployeeOccupation.ADM) {
            employee = new AdministrationMember();
        } else if(type == EmployeeOccupation.FOODS) {
            employee = new FoodServiceMember();
        }
        return employee;
    }
}
