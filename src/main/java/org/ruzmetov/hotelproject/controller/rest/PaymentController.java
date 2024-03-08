package org.ruzmetov.hotelproject.controller.rest;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.PaymentUpdateDto;
import org.ruzmetov.hotelproject.entity.Payment;
import org.ruzmetov.hotelproject.service.interf.PaymentService;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/checkIsPaidById")
//    // http://localhost:8080/payment/checkIsPaidById/48325ff0-3efc-43c7-bd4c-2896ad9d140f
//    public PaymentCheckDto checkThePaymentStatusById(@PathVariable(value = "id") String id) {
//        return paymentService.checkThePaymentStatus(UUID.fromString(id));
//
//    }

    @PostMapping("/createOnePayment")  // http://localhost:8080/payment/createOnePayment
    @ResponseBody
    public Payment postCreatePayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }


    @PutMapping("/updateOnePayment/{id}")
    // http://localhost:8080/payment/updateOnePayment/48325ff0-3efc-43c7-bd4c-2896ad9d140f
    public Payment updatePaymentByPaymentId(@PathVariable(value = "id") String id, @RequestBody PaymentUpdateDto paymentUpdateDto) {
        return paymentService.updatePaymentById(id, paymentUpdateDto);
    }


    @DeleteMapping("/delete/{id}") // http://localhost:8080/payment/delete/48325ff0-3efc-43c7-bd4c-2896ad9d140f
    public Payment deletePaymentByPaymentId(@PathVariable("id") String id) {
        return paymentService.deletePaymentById(id);
    }
}
