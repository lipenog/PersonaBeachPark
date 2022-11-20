package com.example.personabeachpark;

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
    }
}
