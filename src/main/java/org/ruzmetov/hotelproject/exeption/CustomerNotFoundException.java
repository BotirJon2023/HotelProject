package org.ruzmetov.hotelproject.exeption;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {
        super(message);
    }


}
