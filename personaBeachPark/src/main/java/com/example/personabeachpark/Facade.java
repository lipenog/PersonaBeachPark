package com.example.personabeachpark;

import com.example.personabeachpark.equipmentsInventory.Equipment;
import com.example.personabeachpark.equipmentsInventory.EquipmentInventory;
import com.example.personabeachpark.exceptions.equipmentsRelated.EquipmentInventoryException;
import com.example.personabeachpark.exceptions.guestRelated.FamilyMemberException;
import com.example.personabeachpark.guest.Guest;
import com.example.personabeachpark.guest.Member;
import com.example.personabeachpark.usersData.User;
import com.example.personabeachpark.usersData.user.UserType;

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

    public void logUsers(){
        for(User x : users){
            System.out.println(x.toString());
        }
    }

    public void addUserToData(String id, String fName, String lName, UserType userType){
        if(getUser(id) != null){
            return;
        }
        users.add(new User(fName, lName, id, userType));
    }

    public void removeUserFromData(String id){
        User e = getUser(id);
        if(e == null){
            return;
        }
        users.remove(e);
    }
    public User getUser(String userId){
        for(User x : users){
            if(x.getId() == userId)
                return x;
        }
        return null;
    }

    public void addMemberToUserFamily(String userId, Member member){
        User user = getUser(userId);
        if(user == null){
            return;
        }
        if(user.getUserType() == UserType.GUEST){
            Guest guest = (Guest) user.getUserRegistration();
            try{
                guest.addMember(member);
            } catch (FamilyMemberException e){
                e.getMessage();
            }
        }
    }
}
