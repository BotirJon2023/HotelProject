package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Payment;
import org.ruzmetov.hotelproject.repository.PaymentRepository;
import org.ruzmetov.hotelproject.service.interf.PaymentService;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;


    @Override
    public Payment getAccById(UUID id) {


        return paymentRepository.getPaymentByPaymentId(UUID.fromString(String.valueOf(id)));

    }
}
