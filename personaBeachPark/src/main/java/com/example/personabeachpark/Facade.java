package com.example.personabeachpark;

import com.example.personabeachpark.equipmentsInventory.Equipment;
import com.example.personabeachpark.equipmentsInventory.EquipmentInventory;
import com.example.personabeachpark.exceptions.equipmentsRelated.EquipmentInventoryException;
import com.example.personabeachpark.usersData.User;

import java.util.ArrayList;

public class Facade {
    private ArrayList<User> users;
    private EquipmentInventory equipmentInventory;

    public Facade(){
        users = new ArrayList<>();
        equipmentInventory = EquipmentInventory.getInstance();
    }

    public void addEquipment(String name, int quantity){
        try {
            equipmentInventory.addEquipment(name, quantity);
        } catch (EquipmentInventoryException e) {
            System.out.println(e.getMessage());
            equipmentInventory.increaseEquipment(name, quantity);
        }
    }

    public void removeEquipment(String name){
        try {
            equipmentInventory.removeEquipment(name);
        } catch (EquipmentInventoryException e){
            System.out.println(e.getMessage());
        }
    }

    public void decreaseEquipment(String name, int quantity){
        equipmentInventory.decreaseEquipment(name, quantity);
    }

    public void logEquipments(){
        for(Equipment x : equipmentInventory.getEquipments()){
            System.out.println(x.toString());
        }
    }
}
