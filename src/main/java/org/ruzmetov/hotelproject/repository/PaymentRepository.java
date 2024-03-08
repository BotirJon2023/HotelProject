package org.ruzmetov.hotelproject.repository;

import org.ruzmetov.hotelproject.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    Payment findPaymentByPaymentId(UUID id);

//    PaymentCheckDto checkThePaymentStatus(Payment paymentId);

    Payment deletePaymentByPaymentId(UUID id);


}
