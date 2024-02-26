package org.ruzmetov.hotelproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "reservation")
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id", columnDefinition = "UUID")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID reservationId;

    @ManyToOne
    @JoinColumn(name = "reservation_customer_id")
    @JsonIgnore
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "reservation_room_id", referencedColumnName = "room_id")
    private Room room;

    @OneToOne
    @JoinColumn(name = "reservation_event_id", referencedColumnName = "event_id")
    private Event event;

    @OneToOne
    @JoinColumn(name = "reservation_service_id", referencedColumnName = "service_id")
    private Service service;

    @Column(name = "reservation_total_amount")
    private double totalAmount;

    @OneToOne
    @JoinColumn(name = "reservation_payment_id", referencedColumnName = "payment_id")
    private Payment payment;

    @Column(name = "reservation_cancelled_info")
    private String cancellationInfo;

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
                ", customerId=" + customer +
                ", roomId=" + room +
                ", eventId=" + event +
                ", serviceId=" + service +
                ", totalAmount=" + totalAmount +
                ", cancellationInfo='" + cancellationInfo + '\'' +
                '}';
    }
}

