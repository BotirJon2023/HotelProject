package org.ruzmetov.hotelproject.service.interf;

import org.ruzmetov.hotelproject.dto.PaymentUpdateDto;
import org.ruzmetov.hotelproject.entity.Payment;

import java.util.UUID;

public interface PaymentService {

    Payment getPaymentById(UUID id);

    Payment createPayment(Payment payment);

    Payment updatePaymentById(String id, PaymentUpdateDto paymentUpdateDto);

    Payment deletePaymentById(String id);



}
