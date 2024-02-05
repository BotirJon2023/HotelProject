package org.ruzmetov.hotelproject.controller.page;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.PaymentUpdateDto;
import org.ruzmetov.hotelproject.dto.ReservationUpdateDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Payment;
import org.ruzmetov.hotelproject.entity.Reservation;
import org.ruzmetov.hotelproject.service.interf.ReservationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/{id}") // http://localhost:8080/reservation/31ab5b88-78fe-40ac-a7af-499222c4959d
    public Reservation getReservationByReservationId(@PathVariable("id") String id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping("/createOneReservation")  // http://localhost:8080/reservation/createOneReservation
    @ResponseBody
    public Reservation postCreateReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @PutMapping("/updateOneReservation/{id}")
    // http://localhost:8080/reservation/updateOneReservation/31ab5b88-78fe-40ac-a7af-499222c4959d
    public Reservation updateReservationByReservationId(@PathVariable(value = "id") String id, @RequestBody ReservationUpdateDto reservationUpdateDto) {
        return reservationService.updateReservationById(id, reservationUpdateDto);
    }


    @DeleteMapping("/delete/{id}") // http://localhost:8080/reservation/delete/31ab5b88-78fe-40ac-a7af-499222c4959d
    public Reservation deleteReservationByReservationId(@PathVariable("id") String id) {
        return reservationService.deleteReservationById(id);
    }
}
