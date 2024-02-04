package org.ruzmetov.hotelproject.exeption;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException (String message) {
        super(message);
    }

}
