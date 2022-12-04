package com.example.personabeachpark.usersData.userBuilder;

import com.example.personabeachpark.employees.Employee;
import com.example.personabeachpark.employees.employeeFactory.EmployeeFactory;
import com.example.personabeachpark.employees.occupation.EmployeeOccupation;
import com.example.personabeachpark.guest.Guest;
import com.example.personabeachpark.guest.passes.types.PassType;
import com.example.personabeachpark.usersData.User;
import com.example.personabeachpark.usersData.data.Address;
import com.example.personabeachpark.usersData.data.Photo;

public class UserBuilder {
    private static UserBuilder singleton;
    private User user;
    private EmployeeFactory employeeFactory;
    private UserBuilder(){
        employeeFactory = EmployeeFactory.getInstance();
    }
    public static UserBuilder getInstance(){
        if(singleton == null){
            singleton = new UserBuilder();
        }
        return singleton;
    }

    public void setGuest(PassType type){
        user = new Guest(type);
    }

    public void setEmployee(EmployeeOccupation type, double wage, String workHours){
        user = employeeFactory.createOccupation(type);
        Employee employee = (Employee) user;
        employee.setWage(wage);
        employee.setWorkHours(workHours);
    }

    public void setSuperBasic(String firstName, String lastName, String id){
        if(user == null){
            return;
        }
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
    }

    public void setBasic(String firstName, String lastName, String mail, String phoneNumber, String id, String login, String password){
        if(user == null){
            return;
        }
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMail(mail);
        user.setPhoneNumber(phoneNumber);
        user.setLogin(login);
        user.setPassword(password);
    }

    public void setAdvanced(Photo photo, Address address){
        if(user == null){
            return;
        }
        user.setPhoto(photo);
        user.setAddress(address);
    }

    public User getUser(){
        return user;
    }
}
