package com.example.personabeachpark.usersData.userService;

import com.example.personabeachpark.employees.occupation.EmployeeOccupation;
import com.example.personabeachpark.exceptions.guestRelated.FamilyMemberException;
import com.example.personabeachpark.guest.Guest;
import com.example.personabeachpark.guest.Member;
import com.example.personabeachpark.guest.passes.types.PassType;
import com.example.personabeachpark.usersData.User;
import com.example.personabeachpark.usersData.userBuilder.UserBuilder;

import java.util.ArrayList;

public class UserService {
    private static UserService singleton;
    private UserBuilder userBuilder;
    private ArrayList<User> users;

    private UserService(){
        users = new ArrayList<>();
        userBuilder = UserBuilder.getInstance();
    }

    public static UserService getInstance() {
        if(singleton == null) {
            singleton = new UserService();
        }
        return singleton;
    }

    public void logUsers(){
        for(User x : users){
            System.out.println(x.toString());
        }
    }

    public void addGuestToData(String id, String fName, String lName, PassType type){
        if(getUser(id) != null){
            return;
        }
        userBuilder.setGuest(type);
        userBuilder.setSuperBasic(fName, lName, id);
        users.add(userBuilder.getUser());
    }
    public void addEmployeeToData(String id, String fName, String lName, double wage, String workHours, EmployeeOccupation type){
        if(getUser(id) != null){
            return;
        }
        userBuilder.setEmployee(type, wage, workHours);
        userBuilder.setSuperBasic(fName, lName, id);
        users.add(userBuilder.getUser());
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
        if(user instanceof Guest){
            Guest guest = (Guest) user;
            try{
                guest.addMember(member);
            } catch (FamilyMemberException e){
                e.getMessage();
            }
        }
    }
}

