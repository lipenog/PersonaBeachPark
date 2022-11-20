package com.example.personabeachpark.equipmentsInventory;

import com.example.personabeachpark.exceptions.equipmentsRelated.EquipmentInventoryException;

import java.util.ArrayList;

public class EquipmentInventory {
    private ArrayList<Equipment> equipments;
    private static EquipmentInventory singleton;

    private EquipmentInventory(){
        equipments = new ArrayList<>();
    }

    public static EquipmentInventory getInstance(){
        if(singleton == null){
            singleton = new EquipmentInventory();
        }
        return singleton;
    }

    public Equipment getEquipment(String name){
        for(Equipment x : equipments){
            if(x.getName() == name){
                return x;
            }
        }
        return null;
    }

    public ArrayList<Equipment> getEquipments(){
        return equipments;
    }

    public void addEquipment(String name, int quantity) throws EquipmentInventoryException {
        if(getEquipment(name) != null){
            throw new EquipmentInventoryException("The equipment is already in the inventory!" +
                    "increasing the existing one");
        }
        if(quantity <= 0) {
            throw new EquipmentInventoryException("Insert a valid number!");
        }
        equipments.add(new Equipment(name, quantity));
    }

    public void increaseEquipment(String name, int quantity){
        Equipment e = getEquipment(name);
        try{
            if(e != null){
                e.increaseQuantity(quantity);
            }
        } catch (EquipmentInventoryException ex){
            System.out.println(ex.getMessage());
        }
    }


    public void removeEquipment(String name) throws EquipmentInventoryException {
        Equipment e = getEquipment(name);
        if(e == null){
            throw new EquipmentInventoryException("The equipment does not exist in the inventory!");
        }

        equipments.remove(e);
    }

    public void decreaseEquipment(String name, int quantity){
        Equipment e = getEquipment(name);
        if(e == null){
            return;
        }
        try{
            if(e.getQuantity() == quantity){
                removeEquipment(name);
            } else {
                e.decreaseQuantity(quantity);
            }
        } catch (EquipmentInventoryException ex){
            System.out.println(ex.getMessage());
        }
    }
}
