package com.example.personabeachpark.employees.employeeFactory;

import com.example.personabeachpark.employees.occupation.EmployeeOccupation;
import com.example.personabeachpark.employees.types.ActivitiesTeamMember;
import com.example.personabeachpark.employees.types.AdministrationMember;
import com.example.personabeachpark.employees.types.FoodServiceMember;
import com.example.personabeachpark.employees.types.Occupation;

public class OccupationFactory {
    private static OccupationFactory singleton;
    private Occupation occupation;
    private OccupationFactory(){

    }

    public static OccupationFactory getInstance(){
        if(singleton == null){
            singleton = new OccupationFactory();
        }
        return singleton;
    }

    public Occupation createOccupation(EmployeeOccupation type){
        if(type == EmployeeOccupation.ACTIVITIES){
            occupation = new ActivitiesTeamMember();
        } else if (type == EmployeeOccupation.ADM) {
            occupation = new AdministrationMember();
        } else if(type == EmployeeOccupation.FOODS) {
            occupation = new FoodServiceMember();
        }
        return occupation;
    }
}
