package com.example.personabeachpark.usersData;

import com.example.personabeachpark.usersData.data.Address;
import com.example.personabeachpark.usersData.data.Photo;
import com.example.personabeachpark.usersData.userBuilder.UserBuilder;

public abstract class User {
    private Address address;
    private Photo photo;
    private UserBuilder userBuilder = UserBuilder.getInstance();


    private String firstName;
    private String lastName;
    private String mail;
    private String phoneNumber;
    private String id;
    private String login;
    private String password;

    public User(){

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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



    @Override
    public String toString() {
        return "[" +
                "Id=" + id +
                ", Name= '" + firstName + " " + lastName + '\'';
    }
}
