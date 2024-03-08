package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.ReservationUpdateDto;
import org.ruzmetov.hotelproject.entity.Reservation;
import org.ruzmetov.hotelproject.exception.ReservationNotFoundException;
import org.ruzmetov.hotelproject.repository.ReservationRepository;
import org.ruzmetov.hotelproject.service.interf.ReservationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Reservation getReservationById(String id) {
        return reservationRepository.findReservationByReservationId(UUID.fromString(String.valueOf(id)));
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Reservation updateReservationById(String id, ReservationUpdateDto reservationUpdateDto) {
        Reservation reservation = reservationRepository.findById(UUID.fromString(id)).orElseThrow(() -> new ReservationNotFoundException("Reservation with this id not found!"));
        reservation.setTotalAmount(reservationUpdateDto.getTotalAmount());
        reservation.setCancellationInfo(reservationUpdateDto.getCancellationInfo());
        return reservationRepository.save(reservation);
    }


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Reservation deleteReservationById(String id) {
        return reservationRepository.deleteReservationByReservationId(UUID.fromString(id));
    }
}
