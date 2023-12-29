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
@Table(name = "payment")
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "reservation_payment_id")
    @JoinColumn(name = "payment_id", referencedColumnName = "customer_payment_id")
    @JoinColumn(name = "payment_id", referencedColumnName = "service_payment_id")
    @JoinColumn(name = "payment_id", referencedColumnName = "event_payment_id")
    @Column(name = "payment_id")
    private UUID paymentId;

    @ManyToMany
    @JoinColumn(name = "payment_room_number", referencedColumnName = "room_number")
    @Column(name = "payment_room_number")
    private int roomNumber;

    @ManyToMany
    @JoinColumn(name = "payment_service_id", referencedColumnName = "service_id")
    @Column(name = "payment_service_id")
    private UUID serviceId;

    @ManyToOne
    @JoinColumn(name = "payment_event_id", referencedColumnName = "event_id")
    @Column(name = "payment_event_id")
    private UUID eventId;

    @ManyToMany
    @JoinColumn (name = "payment_customer_first_name", referencedColumnName = "customer_first_name")
    @Column(name = "payment_customer_first_name")
    private String customerFirstName;

    @ManyToMany
    @JoinColumn (name = "payment_customer_last_name", referencedColumnName = "customer_last_name")
    @Column(name = "payment_customer_last_name")
    private String customerLastName;

    @Column(name = "payment_credit_card_number")
    private int creditCardNumber;

    @Column(name = "payment_credit_card_expiring_date")
    private Date creditCardExpiringDate;

    @Column(name = "payment_credit_card_CVV")
    private int creditCardCVV;

    @ManyToMany
    @JoinColumn(name = "payment_method", referencedColumnName = "reservation_payment_method")
    @JoinColumn(name = "payment_method", referencedColumnName = "customer_payment_method")
    @JoinColumn(name = "payment_method", referencedColumnName = "service_payment_method")
    @JoinColumn(name = "payment_method", referencedColumnName = "event_payment_method")
    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToMany
    @JoinColumn(name = "payment_total_amount", referencedColumnName = "reservation_total_amount")
    @JoinColumn(name = "payment_total_amount", referencedColumnName = "customer_total_amount")
    @JoinColumn(name = "payment_total_amount", referencedColumnName = "event_total_price")
    @JoinColumn(name = "payment_total_amount", referencedColumnName = "service_total_price")
    @JoinColumn(name = "payment_total_amount", referencedColumnName = "room_total_price")
    @Column(name = "payment_total_amount")
    private double totalAmount;

    @Column(name = "payment_transaction_id")
    private UUID transactionId;

    @Column(name = "payment_transaction_history")
    private String transactionHistory;

    @ManyToMany
    @JoinColumn (name = "payment_employee_id", referencedColumnName = "employee_id")
    @Column(name = "payment_employee_id")
    private UUID employeeId;

    @ManyToMany
    @JoinColumn (name = "payment_administrator_id", referencedColumnName = "administrator_id")
    @Column(name = "payment_administrator_id")
    private UUID administratorId;

    @Column(name = "payment_create")
    private Date paymentTabCreate;

    @Column(name = "payment_update")
    private Date paymentTabUpdate;

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
        return "CommonPayment{" +
                "paymentId=" + paymentId +
                ", roomNumber=" + roomNumber +
                ", serviceId=" + serviceId +
                ", eventId=" + eventId +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", creditCardExpiringDate=" + creditCardExpiringDate +
                ", creditCardCVV=" + creditCardCVV +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", totalAmount=" + totalAmount +
                ", transactionId=" + transactionId +
                ", transactionHistory='" + transactionHistory + '\'' +
                ", employeeId=" + employeeId +
                ", administratorId=" + administratorId +
                ", paymentTabCreate=" + paymentTabCreate +
                ", paymentTabUpdate=" + paymentTabUpdate +
                '}';
    }
}
