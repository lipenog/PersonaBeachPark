package com.example.personabeachpark.booking.areas;

import java.time.LocalDate;

public class BookedArea {
    private Area area;
    private LocalDate date;

    public BookedArea(Area area, int month, int day, int year){
        this.area = area;
        date = LocalDate.of(year, month, day);
    }

    public BookedArea(Area area, LocalDate date) {
        this.area = area;
        this.date = date;
    }

    public Area getArea() {
        return area;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAreaID(){
        return area.getAreaID();
    }

    @Override
    public String toString() {
        return "[" +
                "area=" + area.toString() +
                ", date=" + date +
                ']';
    }
}
