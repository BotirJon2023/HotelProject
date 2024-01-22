package org.ruzmetov.hotelproject.service.interf;

import org.ruzmetov.hotelproject.entity.Payment;
import org.ruzmetov.hotelproject.entity.Reservation;

import java.util.UUID;

public interface PaymentService {

    Payment getAccById(UUID id);

}
