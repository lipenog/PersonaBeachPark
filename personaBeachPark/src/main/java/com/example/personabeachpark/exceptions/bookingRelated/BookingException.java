package com.example.personabeachpark.exceptions.bookingRelated;

public class BookingException extends Exception{
    public BookingException() {

    }
    public BookingException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }

    public void setMessage(String message){
        setMessage(message);
    }
}
