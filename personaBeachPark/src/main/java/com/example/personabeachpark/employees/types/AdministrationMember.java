package com.example.personabeachpark.employees.types;

import com.example.personabeachpark.employees.Employee;
import com.example.personabeachpark.employees.occupation.EmployeeOccupation;

public class AdministrationMember extends Employee {
    public AdministrationMember() {
        super();
        super.setOccupationType(EmployeeOccupation.ADM);
    }
}
