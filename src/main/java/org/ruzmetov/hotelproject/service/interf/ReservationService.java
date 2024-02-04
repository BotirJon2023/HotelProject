package org.ruzmetov.hotelproject.service.interf;

import org.ruzmetov.hotelproject.entity.Reservation;

public interface ReservationService {

    Reservation getReservationById(String id);

    Reservation deleteReservationById(String id);
}
