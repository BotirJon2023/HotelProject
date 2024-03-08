package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.PaymentUpdateDto;
import org.ruzmetov.hotelproject.entity.Payment;
import org.ruzmetov.hotelproject.exception.PaymentNotFoundException;
import org.ruzmetov.hotelproject.mapper.PaymentMapper;
import org.ruzmetov.hotelproject.repository.PaymentRepository;
import org.ruzmetov.hotelproject.service.interf.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }


    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Payment getPaymentById(UUID id) {
        return paymentRepository.findPaymentByPaymentId(UUID.fromString(String.valueOf(id)));
    }

//    @Override
//    public PaymentCheckDto checkThePaymentStatus(UUID id) {
//        return paymentMapper.toDto(paymentRepository.getReferenceById(id));
//    }


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Payment updatePaymentById(String id, PaymentUpdateDto paymentUpdateDto) {
        Payment payment = paymentRepository.findById(UUID.fromString(id)).orElseThrow(() -> new PaymentNotFoundException("Payment with this id not found!"));
        payment.setPaymentMethod(paymentUpdateDto.getPaymentMethod());
        payment.setPaid(paymentUpdateDto.isPaid());
        payment.setTransactionHistory(paymentUpdateDto.getTransactionHistory());
        return paymentRepository.save(payment);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Payment deletePaymentById(String id) {
        return paymentRepository.deletePaymentByPaymentId(UUID.fromString(id));
    }


}
