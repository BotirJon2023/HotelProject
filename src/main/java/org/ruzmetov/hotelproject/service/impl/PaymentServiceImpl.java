package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.PaymentUpdateDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Payment;
import org.ruzmetov.hotelproject.exeption.CustomerNotFoundException;
import org.ruzmetov.hotelproject.exeption.PaymentNotFoundException;
import org.ruzmetov.hotelproject.repository.PaymentRepository;
import org.ruzmetov.hotelproject.service.interf.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Payment getPaymentById(UUID id) {
        return paymentRepository.findPaymentByPaymentId(UUID.fromString(String.valueOf(id)));
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    @Transactional
    public Payment updatePaymentById(String id, PaymentUpdateDto paymentUpdateDto) {
        Payment payment = paymentRepository.findById(UUID.fromString(id)).orElseThrow(() -> new PaymentNotFoundException("Payment with this id not found!"));
        payment.setPaymentMethod(paymentUpdateDto.getPaymentMethod());
        payment.setPaid(paymentUpdateDto.isPaid());
        payment.setTransactionHistory(paymentUpdateDto.getTransactionHistory());
        return paymentRepository.save(payment);
    }

    @Override
    public Payment deletePaymentById(String id) {
        return paymentRepository.deletePaymentByPaymentId(UUID.fromString(id));
    }
}
