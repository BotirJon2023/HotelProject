package org.ruzmetov.hotelproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
@Entity

public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id", columnDefinition = "UUID")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID paymentId;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_is_paid")
    private boolean isPaid;

    @Column(name = "payment_transaction_history")
    private String transactionHistory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentId, payment.paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", isPaid=" + isPaid +
                ", transactionHistory='" + transactionHistory + '\'' +
                '}';
    }
}

