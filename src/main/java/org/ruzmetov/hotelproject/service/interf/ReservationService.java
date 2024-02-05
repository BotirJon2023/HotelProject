package org.ruzmetov.hotelproject.service.interf;

import org.ruzmetov.hotelproject.dto.ReservationUpdateDto;
import org.ruzmetov.hotelproject.entity.Reservation;

public interface ReservationService {

    Reservation getReservationById(String id);

    Reservation createReservation(Reservation reservation);

    Reservation updateReservationById(String id, ReservationUpdateDto reservationUpdateDto);

    Reservation deleteReservationById(String id);



}
