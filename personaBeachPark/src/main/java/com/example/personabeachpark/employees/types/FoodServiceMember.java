package com.example.personabeachpark.employees.types;

import com.example.personabeachpark.employees.Employee;
import com.example.personabeachpark.employees.occupation.EmployeeOccupation;

public class FoodServiceMember extends Employee {
    public FoodServiceMember() {
        super();
        super.setOccupationType(EmployeeOccupation.FOODS);
    }
}
