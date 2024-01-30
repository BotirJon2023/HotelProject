package org.ruzmetov.hotelproject.repository;

import org.ruzmetov.hotelproject.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    Reservation findReservationByReservationId(UUID id);

}
