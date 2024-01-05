package org.ruzmetov.hotelproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private UUID reservationId;

    @Column(name = "reservation_customer_id")
    private UUID customerId;

    @Column(name = "reservation_room_number")
    private int roomNumber;

    @Column(name = "reservation_event_id")
    private UUID eventId;

    @Column(name = "reservation_service_id")
    private UUID serviceId;

    @Column(name = "reservation_total_amount")
    private double totalAmount;

    @Column(name = "reservation_payment_method")
    private String paymentMethod;

    @Column(name = "reservation_payment_id")
    private UUID paymentId;

    @Column(name = "reservation_transaction_id")
    private UUID transactionId;

    @Column(name = "reservation_transaction_history")
    private String transactionHistory;

    @Column(name = "reservation_cancelled_info")
    private String cancellationInfo;

    @Column(name = "reservation_tab_create")
    private Date reservationCreate;

    @Column(name = "reservation_tab_update")
    private Date reservationUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(reservationId, that.reservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", customerId=" + customerId +
                ", roomNumber=" + roomNumber +
                ", eventId=" + eventId +
                ", serviceId=" + serviceId +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentId=" + paymentId +
                ", transactionId=" + transactionId +
                ", transactionHistory='" + transactionHistory + '\'' +
                ", cancellationInfo='" + cancellationInfo + '\'' +
                ", reservationCreate=" + reservationCreate +
                ", reservationUpdate=" + reservationUpdate +
                '}';
    }
}
