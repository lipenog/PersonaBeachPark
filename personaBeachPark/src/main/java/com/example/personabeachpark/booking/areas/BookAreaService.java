package com.example.personabeachpark.booking.areas;

import com.example.personabeachpark.exceptions.bookingRelated.BookingException;
import com.example.personabeachpark.guest.Guest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class BookAreaService {
    private Set<Area> areas;
    private Set<BookedArea> bookedAreas;

    public BookAreaService(){
        areas = new HashSet<>();
        bookedAreas = new HashSet<>();
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

    public void makeBook(Guest guest, Area area,  LocalDate date) throws BookingException{
        if(guest == null){
            throw new BookingException("guest does not exist");
        }
        if(area == null){
            throw new BookingException("area does not exist");
        }
        if(isBooked(area, date) != null){
            throw new BookingException("area is already booked");
        }
        if(LocalDate.now().isAfter(date)){
            throw new BookingException("can not book in the past");
        }
        BookedArea bookedArea = new BookedArea(area, date);
        bookedArea.setGuestId(guest.getId());
        guest.addBooking(bookedArea);
        bookedAreas.add(bookedArea);
    }

    public void removeBook(Guest guest, Area area, LocalDate date)throws BookingException{
        if(guest == null){
            throw new BookingException("guest does not exist");
        }
        if(area == null){
            throw new BookingException("area does not exist");
        }
        if(isBooked(area, date) == null){
            throw new BookingException("area is not booked");
        }

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

    public Set<BookedArea> getBookByArea(String areaId) throws BookingException{
        Area area = getArea(areaId);
        if(area == null){
            throw new BookingException("area does not exist");
        }
        Set<BookedArea> result = new HashSet<>();
        for(BookedArea book : bookedAreas){
            if(book.getArea() == area){
                result.add(book);
            }
        }
        return result;
    }


}
