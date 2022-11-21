package com.example.personabeachpark.usersData.userFactory;

import com.example.personabeachpark.employees.types.ActivitiesTeamMember;
import com.example.personabeachpark.employees.types.AdministrationMember;
import com.example.personabeachpark.employees.types.FoodServiceMember;
import com.example.personabeachpark.guest.Guest;
import com.example.personabeachpark.guest.guestFactory.PassFactory;
import com.example.personabeachpark.guest.passes.IPass;
import com.example.personabeachpark.guest.passes.types.PassType;
import com.example.personabeachpark.usersData.user.UserRegistration;
import com.example.personabeachpark.usersData.user.UserType;

public class UserRegistrationFactory {
    private UserRegistration userRegistration;
    private PassFactory passFactory;
    private static UserRegistrationFactory singleton;
    private UserRegistrationFactory(){
        passFactory = PassFactory.getInstance();
    }

    public static UserRegistrationFactory getInstance(){
        if(singleton == null){
            singleton = new UserRegistrationFactory();
        }
        return singleton;
    }

    public UserRegistration createUserRegistration(UserType type){
        if(type == UserType.ACTIVITIES){
            userRegistration = new ActivitiesTeamMember();
        } else if (type == UserType.ADM) {
            userRegistration = new AdministrationMember();
        } else if(type == UserType.FOOD) {
            userRegistration = new FoodServiceMember();
        } else if(type == UserType.GUEST){
            userRegistration = createUserRegistrationGuest();
        }
        return userRegistration;
    }

    private UserRegistration createUserRegistrationGuest(){
        // ask for guest input for pass
        // temp PassType.MONTHLY
        Guest guest = new Guest(PassType.MONTHLY);
        IPass pass = passFactory.createPass(PassType.MONTHLY);
        guest.setPass(pass);
        userRegistration = guest;

        return userRegistration;
    }

}
