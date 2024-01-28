package org.ruzmetov.hotelproject.controller.page;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Payment;
import org.ruzmetov.hotelproject.service.interf.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor

public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/{id}")
    public Payment getAccountById(@PathVariable("id") String id) {
        return paymentService.getAccById(UUID.fromString(id));

    }

}
