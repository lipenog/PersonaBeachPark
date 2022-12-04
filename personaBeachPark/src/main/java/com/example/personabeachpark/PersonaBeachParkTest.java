package com.example.personabeachpark;

import com.example.personabeachpark.booking.areas.BookAreaService;
import com.example.personabeachpark.employees.occupation.EmployeeOccupation;
import com.example.personabeachpark.guest.Member;
import com.example.personabeachpark.guest.passes.types.PassType;
import com.example.personabeachpark.usersData.userService.UserService;

import java.time.LocalDate;

public class PersonaBeachParkTest {
    public static void main(String[] args) {
        UserService userService = UserService.getInstance();
        BookAreaService bookAreaService = new BookAreaService();


        userService.addGuestToData("1", "Yu", "Narukami", PassType.ULTIMATE);
        userService.addGuestToData("5", "luiz", "nogueira", PassType.YEAR);
        userService.addGuestToData("6", "Matheus", "Mama", PassType.ULTIMATE);
        userService.addEmployeeToData("2", "Rise", "Kujikawa", 2500, "50", EmployeeOccupation.ACTIVITIES);
        userService.addEmployeeToData("3", "Tohru", "Adachi", 15000, "10", EmployeeOccupation.ADM);
        userService.addEmployeeToData("4", "Teddie", "Teddie", 5, "150000", EmployeeOccupation.FOODS);


        userService.addMemberToUserFamily("1", new Member("Nanako", "Dojima"));
        userService.addMemberToUserFamily("1", new Member("Ryotaro", "Dojima"));

        userService.logUsers();

        bookAreaService.addArea("0", "grill pool", "");
        bookAreaService.addArea("1", "abcx", "");
        bookAreaService.addArea("2", "cdes", "");
        bookAreaService.addArea("3", "asd", "");

        try {
            bookAreaService.makeBook("1", "2", LocalDate.of(2022, 12, 15));
            bookAreaService.makeBook("5", "3", LocalDate.of(2022, 12, 15));
            //bookAreaService.makeBook("3", "0", LocalDate.of(2022, 12, 4));
            //bookAreaService.makeBook("6", "3", LocalDate.of(2022, 12, 15));
            //bookAreaService.makeBook("1", "4", LocalDate.of(2022, 12, 15));
            //bookAreaService.removeBook("5", "3", LocalDate.of(2022, 12, 15));
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        bookAreaService.logAreas();
        bookAreaService.logBookedAreas();

    }
}
