package com.example.personabeachpark;

import com.example.personabeachpark.employees.occupation.EmployeeOccupation;
import com.example.personabeachpark.guest.Member;
import com.example.personabeachpark.guest.passes.types.PassType;

import java.time.LocalDate;

public class PersonaBeachParkTest {
    public static void main(String[] args) {
        Facade facade = new Facade();


        facade.addGuest("1", "Yu", "Narukami", PassType.ULTIMATE);
        facade.addGuest("5", "luiz", "nogueira", PassType.YEAR);
        facade.addGuest("6", "Matheus", "Mama", PassType.ULTIMATE);
        facade.addEmployee("2", "Rise", "Kujikawa", 2500, "50", EmployeeOccupation.ACTIVITIES);
        facade.addEmployee("3", "Tohru", "Adachi", 15000, "10", EmployeeOccupation.ADM);
        facade.addEmployee("4", "Teddie", "Teddie", 5, "150000", EmployeeOccupation.FOODS);


        facade.addFamilyMember("1", new Member("Nanako", "Dojima"));
        facade.addFamilyMember("1", new Member("Ryotaro", "Dojima"));

        facade.logUser();

        facade.addArea("0", "grill pool", "");
        facade.addArea("1", "abcx", "");
        facade.addArea("2", "cdes", "");
        facade.addArea("3", "asd", "");

        facade.addBook("1", "2", LocalDate.of(2022, 12, 15));
        facade.addBook("5", "3", LocalDate.of(2022, 12, 15));
        facade.addBook("6", "2", LocalDate.of(2022, 12, 20));
        facade.addBook("5", "2", LocalDate.of(2023, 1, 10));
        facade.addBook("1", "2", LocalDate.of(2023, 2, 5));

        facade.logArea();
        facade.logBook();

        System.out.println(facade.getBooksByArea("2"));
        System.out.println(facade.getBooksByGuest("1"));
    }
}
