package com.example.personabeachpark;

import com.example.personabeachpark.booking.areas.Area;
import com.example.personabeachpark.booking.areas.BookAreaService;
import com.example.personabeachpark.booking.areas.BookedArea;
import com.example.personabeachpark.employees.occupation.EmployeeOccupation;
import com.example.personabeachpark.exceptions.bookingRelated.BookingException;
import com.example.personabeachpark.guest.Guest;
import com.example.personabeachpark.guest.Member;
import com.example.personabeachpark.guest.passes.types.PassType;
import com.example.personabeachpark.usersData.User;
import com.example.personabeachpark.usersData.userService.UserService;

import java.time.LocalDate;
import java.util.Set;

public class Facade {
    private UserService userService;
    private BookAreaService bookAreaService;

    public Facade(){
        userService = new UserService();
        bookAreaService = new BookAreaService();
    }

    public void addGuest(String id, String fName, String lName, PassType type){
        userService.addGuestToData(id, fName, lName, type);
    }

    public void addEmployee(String id, String fName, String lName, double wage, String workHours, EmployeeOccupation type){
        userService.addEmployeeToData(id, fName, lName, wage, workHours, type);
    }

    public void addFamilyMember(String guestId, Member member){
        userService.addMemberToUserFamily(guestId, member);
    }

    public void removeUser(String id){
        User user = userService.getUser(id);
        // if is a guest all of his books will be deleted
        if(user instanceof Guest){
            Guest guest = (Guest) user;
            bookAreaService.removeBooks(guest.getBooks());
        }
        userService.removeUserFromData(id);
    }

    public void logUser(){
        userService.logUsers();
    }

    public void addArea(String areaID, String name, String type, PassType passType){
        bookAreaService.addArea(areaID, name, type, passType);
    }

    public void addBook(String guestId, String areaId, LocalDate date){
        User user = userService.getUser(guestId);
        Area area = bookAreaService.getArea(areaId);
        if(!(user instanceof Guest)){
            System.out.println("Only guests can book");
            return;
        }
        try{
            bookAreaService.makeBook((Guest) user, area, date);
        } catch (BookingException e){
            System.out.println(e.getMessage());
        }

    }

    public void removeArea(String areaId){
        try {
            bookAreaService.removeArea(areaId);
        } catch (BookingException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeBook(String guestId, String areaId, LocalDate date){
        User user = userService.getUser(guestId);
        Area area = bookAreaService.getArea(areaId);
        if(!(user instanceof Guest)){
            System.out.println("Not a guest");
        }
        try{
            bookAreaService.removeBook((Guest) user, area, date);
        } catch (BookingException e){
            System.out.println(e.getMessage());
        }
    }

    public Set<BookedArea> getBooksByArea(String areaId){
        try {
            return bookAreaService.getBookByArea(areaId);
        }catch (BookingException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<BookedArea> getBooksByGuest(String guestId){
        User user = userService.getUser(guestId);
        if(!(user instanceof Guest)){
            System.out.println("Not a guest");
        }
        return ((Guest) user).getBooks();
    }

    public void logArea(){
        bookAreaService.logAreas();
    }
    public void logBook(){
        bookAreaService.logBookedAreas();
    }

}
