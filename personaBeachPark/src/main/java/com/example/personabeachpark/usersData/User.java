package com.example.personabeachpark.usersData;

import com.example.personabeachpark.usersData.data.Address;
import com.example.personabeachpark.usersData.data.Photo;
import com.example.personabeachpark.usersData.user.UserRegistration;
import com.example.personabeachpark.usersData.user.UserType;
import com.example.personabeachpark.usersData.userFactory.UserRegistrationFactory;

public class User {
    private Address address;
    private UserRegistration userRegistration;
    private UserType userType;
    private Photo photo;
    private UserRegistrationFactory userFactory = UserRegistrationFactory.getInstance();


    private String firstName;
    private String lastName;
    private String mail;
    private String phoneNumber;
    private String id;
    private String login;
    private String password;

    // add a userRegistration factory, and a param String userType
    public User(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public User(String firstName, String lastName, String id, UserType userType){
        this(firstName, lastName, id);
        userRegistration = userFactory.createUserRegistration(userType);
        this.userType = userType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserRegistration getUserRegistration() {
        return userRegistration;
    }

    public void setUserRegistration(UserRegistration userRegistration) {
        this.userRegistration = userRegistration;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "[" +
                "Id = '" + id +
                ", Name = '" + firstName + " " + lastName + '\'' +
                ", Type = " + userType + '\'' +
                " -> " + userRegistration.toString() +
                ']';
    }
}
