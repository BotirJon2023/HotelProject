package org.ruzmetov.hotelproject.service.interf;

import org.ruzmetov.hotelproject.entity.Payment;

import java.util.UUID;

public interface PaymentService {

    Payment getPaymentById(UUID id);

    Payment deletePaymentById(String id);
}
