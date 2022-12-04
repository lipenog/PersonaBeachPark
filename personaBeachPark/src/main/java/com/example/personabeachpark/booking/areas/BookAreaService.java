package com.example.personabeachpark.booking.areas;

import com.example.personabeachpark.exceptions.bookingRelated.BookingException;
import com.example.personabeachpark.guest.Guest;
import com.example.personabeachpark.usersData.User;
import com.example.personabeachpark.usersData.userService.UserService;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookAreaService {
    private ArrayList<Area> areas;
    private ArrayList<BookedArea> bookedAreas;
    private UserService userService;

    public BookAreaService(){
        areas = new ArrayList<>();
        bookedAreas = new ArrayList<>();
        userService = UserService.getInstance();
    }

    public Area getArea(String areaID){
        for(Area x : areas){
            if(x.getAreaID() == areaID){
                return x;
            }
        }
        return null;
    }

    public BookedArea isBooked(Area area, LocalDate date){
        for(BookedArea x : bookedAreas){
            if(x.getArea() == area && x.getDate().equals(date)){
                return x;
            }
        }
        return null;
    }

    public BookedArea isBookedBy(Guest guest, Area area, LocalDate date){
        for(BookedArea x : bookedAreas){
            if(x.getArea() == area && x.getDate().equals(date) && guest.isBooked(x)){
                return x;
            }
        }
        return null;
    }

    public void addArea(String areaID, String name, String type){
        if(getArea(areaID) != null){
            return;
        }
        areas.add(new Area(areaID, name, type));
    }

    public void removeArea(String areaID){
        if(getArea(areaID) == null){
            return;
        }
        areas.remove(getArea(areaID));
    }

    private void treatBooking(String guestID, String areaID, LocalDate date) throws BookingException {
        User user = userService.getUser(guestID);
        Area area = getArea(areaID);
        if(!(user instanceof Guest)){
            throw new BookingException("not a guest");
        }
        if(user == null){
            throw new BookingException("guest does not exist");
        }
        if(area == null){
            throw new BookingException("area does not exist");
        }
    }

    public void makeBook(String guestID, String areaID, LocalDate date) throws BookingException{
        User user = userService.getUser(guestID);
        Area area = getArea(areaID);

        treatBooking(guestID, areaID, date);
        if(isBooked(area, date) != null){
            throw new BookingException("area is already booked");
        }
        if(LocalDate.now().isAfter(date)){
            throw new BookingException("can not book in the past");
        }

        BookedArea bookedArea = new BookedArea(area, date);
        Guest guest = (Guest) user;
        guest.addBooking(bookedArea);
        bookedAreas.add(bookedArea);
    }

    public void removeBook(String guestID, String areaID, LocalDate date) throws BookingException{
        User user = userService.getUser(guestID);
        Area area = getArea(areaID);

        treatBooking(guestID, areaID, date);
        if(isBooked(area, date) == null){
            throw new BookingException("area is not booked");
        }

        Guest guest = (Guest) user;
        BookedArea bookedArea = isBookedBy(guest, area, date);

        if(bookedArea == null){
            throw new BookingException("area is not booked by this guest");
        }


        guest.removeBooking(bookedArea);
        bookedAreas.remove(bookedArea);
    }

    public void logAreas(){
        for(Area x : areas){
            System.out.println(x.toString());
        }
    }

    public void logBookedAreas(){
        for(BookedArea x : bookedAreas){
            System.out.println(x.toString());
        }
    }
}
