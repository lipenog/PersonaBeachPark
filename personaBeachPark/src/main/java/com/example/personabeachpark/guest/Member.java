package com.example.personabeachpark.guest;

import com.example.personabeachpark.usersData.data.Photo;

public class Member {
    private String firstName;
    private String lastName;
    private Photo photo;

    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getFullName(){
        return firstName + lastName;
    }
    @Override
    public String toString() {
        return "(" +
                "Name= '" + firstName + " " + lastName + '\'' +
                ")";
    }
}
