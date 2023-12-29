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
@Table (name = "customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private UUID customerId;

    @ManyToMany
    @JoinColumn (name = "customer_first_name", referencedColumnName = "reservation_customer_first_name")
    @JoinColumn (name = "customer_first_name", referencedColumnName = "payment_customer_first_name")
    @JoinColumn (name = "customer_first_name", referencedColumnName = "feedback_customer_first_name")
    @Column(name = "customer_first_name")
    private String firstName;

    @ManyToMany
    @JoinColumn (name = "customer_last_name", referencedColumnName = "reservation_customer_last_name")
    @JoinColumn (name = "customer_last_name", referencedColumnName = "payment_customer_last_name")
    @JoinColumn (name = "customer_last_name", referencedColumnName = "feedback_customer_last_name")
    @Column(name = "customer_last_name")
    private String lastName;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_phone_number")
    private int phoneNumber;

    @Column(name = "customer_address")
    private String address;

    @ManyToMany
    @JoinColumn (name = "customer_reservation_id", referencedColumnName = "reservation_id")
    @Column(name = "customer_reservation_id")
    private UUID reservationId;

    @Column(name = "customer_reservation_history")
    private String reservationHistory;

    @ManyToOne
    @JoinColumn (name = "customer_room_number", referencedColumnName = "room_number")
    @Column(name = "customer_room_number")
    private int roomNumber;

    @ManyToMany
    @JoinColumn(name = "customer_service_id", referencedColumnName = "service_id")
    @Column(name = "customer_service_id")
    private UUID serviceId;

    @ManyToMany
    @JoinColumn(name = "customer_event_id", referencedColumnName = "event_id")
    @Column(name = "customer_event_id")
    private UUID eventId;

    @Column(name = "customer_loyality_points")
    private String loyalityPoints;

    @ManyToMany
    @JoinColumn (name = "customer_checkIn_date", referencedColumnName = "room_checkIn_date")
    @Column(name = "customer_checkIn_date")
    private Date checkInDate;

    @Column(name = "customer_checkIn_status")
    private String checkInStatus;

    @ManyToMany
    @JoinColumn (name = "customer_checkOut_date", referencedColumnName = "room_checkOut_date")
    @Column(name = "customer_checkOut_date")
    private Date checkOutDate;

    @Column(name = "customer_checkOut_status")
    private String checkOutStatus;

    @OneToOne
    @JoinColumn(name = "customer_total_amount", referencedColumnName = "payment_total_amount")
    @Column(name = "customer_total_amount")
    private int totalAmount;

    @OneToOne
    @JoinColumn(name = "customer_payment_method", referencedColumnName = "payment_method")
    @Column(name = "customer_payment_method")
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "customer_payment_id", referencedColumnName = "payment_id")
    @Column(name = "customer_payment_id")
    private UUID paymentId;

    @Column(name = "customer_create")
    private Date customerTabCreate;

    @Column(name = "customer_update")
    private Date customerTabUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public String toString() {
        return "CommonCustomer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", reservationId=" + reservationId +
                ", reservationHistory='" + reservationHistory + '\'' +
                ", roomNumber=" + roomNumber +
                ", serviceId=" + serviceId +
                ", eventId=" + eventId +
                ", loyalityPoints='" + loyalityPoints + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkInStatus='" + checkInStatus + '\'' +
                ", checkOutDate=" + checkOutDate +
                ", checkOutStatus='" + checkOutStatus + '\'' +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentId=" + paymentId +
                ", customerCreate=" + customerTabCreate +
                ", customerUpdate=" + customerTabUpdate +
                '}';
    }
}
