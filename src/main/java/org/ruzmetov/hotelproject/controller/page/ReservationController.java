package org.ruzmetov.hotelproject.controller.page;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Reservation;
import org.ruzmetov.hotelproject.service.interf.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor


public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/{id}") // http://localhost:8080/reservation/31ab5b88-78fe-40ac-a7af-499222c4959d
    public Reservation getReservationByReservationId(@PathVariable("id") String id) {
        return reservationService.getReservationById(id);

    }

}

