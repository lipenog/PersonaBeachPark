package com.example.personabeachpark.equipmentsInventory;

import com.example.personabeachpark.exceptions.equipmentsRelated.EquipmentInventoryException;

public class Equipment {
    private String name;
    private int quantity;

    public Equipment(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int n) throws EquipmentInventoryException {
        if(n <= 0){
            throw new EquipmentInventoryException("Insert a valid number");
        }
        quantity = quantity + n;
    }

    public void decreaseQuantity(int n) throws EquipmentInventoryException {
        int verify = quantity - n;
        if(verify < 0 && n <= 0){
            throw new EquipmentInventoryException("Insert a valid number");
        }

        quantity = verify;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ']';
    }
}
