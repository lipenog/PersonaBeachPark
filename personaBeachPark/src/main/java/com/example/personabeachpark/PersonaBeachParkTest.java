package com.example.personabeachpark;

import com.example.personabeachpark.guest.Member;
import com.example.personabeachpark.usersData.user.UserType;

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

        facade.addUserToData("1", "Yu", "Narukami", UserType.GUEST);
        facade.addUserToData("2", "Rise", "Kujikawa", UserType.ACTIVITIES);
        facade.addUserToData("3", "Tohru", "Adachi", UserType.GUEST);
        facade.addUserToData("4", "Teddie", "Teddie", UserType.FOOD);

        facade.addMemberToUserFamily("1", new Member("Nanako", "Dojima"));
        facade.addMemberToUserFamily("1", new Member("Ryotaro", "Dojima"));

        facade.logUsers();
    }
}
