package org.ruzmetov.hotelproject.exeption;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(String message) {
        super(message);
    }

}
