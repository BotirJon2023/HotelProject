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

    @GetMapping("/{id}") // http://localhost:8080/payment/48325ff0-3efc-43c7-bd4c-2896ad9d140f
    public Payment getPaymentByPaymentId(@PathVariable("id") String id) {
        return paymentService.getPaymentById(UUID.fromString(id));

    }

}
