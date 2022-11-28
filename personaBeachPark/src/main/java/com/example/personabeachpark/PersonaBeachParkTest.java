package com.example.personabeachpark;

import com.example.personabeachpark.employees.occupation.EmployeeOccupation;
import com.example.personabeachpark.guest.Member;
import com.example.personabeachpark.guest.passes.types.PassType;

public class PersonaBeachParkTest {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.addEquipment("beach ball", 3);
        facade.addEquipment("soccer ball", 2);
        facade.addEquipment("tennis ball", 1);
        facade.addEquipment(" ball", 0);
        facade.addEquipment("beach ball", 3);
        facade.addEquipment("tennis ball", 1);
        facade.addEquipment("tennis ball", 0);

        facade.removeEquipment("beach ball");
        facade.decreaseEquipment("soccer ball", 2);


        facade.logEquipments();

        facade.addGuestToData("1", "Yu", "Narukami", PassType.ULTIMATE);
        facade.addEmployeeToData("2", "Rise", "Kujikawa", 2500, "50", EmployeeOccupation.ACTIVITIES);
        facade.addEmployeeToData("3", "Tohru", "Adachi", 15000, "10", EmployeeOccupation.ADM);
        facade.addEmployeeToData("4", "Teddie", "Teddie", 5, "150000", EmployeeOccupation.FOODS);


        facade.addMemberToUserFamily("1", new Member("Nanako", "Dojima"));
        facade.addMemberToUserFamily("1", new Member("Ryotaro", "Dojima"));

        facade.logUsers();
    }
}
