package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Reservation;
import org.ruzmetov.hotelproject.repository.ReservationRepository;
import org.ruzmetov.hotelproject.service.interf.ReservationService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findReservationByReservationId(UUID.fromString(String.valueOf(id)));
    }

    @Override
    public final Reservation deleteReservationById(String id) {
        return reservationRepository.deleteReservationByReservationId(UUID.fromString(id));
    }
}
