package org.ruzmetov.hotelproject.repository;

import org.ruzmetov.hotelproject.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

Payment getPaymentByPaymentId(UUID id);

}
