package org.ruzmetov.hotelproject.exeption;

public class ServiceNotFoundException extends RuntimeException {

    public ServiceNotFoundException (String message) {

        super(message);
    }

}
