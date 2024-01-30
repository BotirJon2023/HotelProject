package org.ruzmetov.hotelproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", columnDefinition = "UUID")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID customerId;

    @Column(name = "customer_first_name")
    private String firstName;

    @Column(name = "customer_last_name")
    private String lastName;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_phone_number")
    private int phoneNumber;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_loyality_point")
    private String loyalityPoints;

    @Column(name = "customer_credit_card_number")
    private int creditCardNumber;

    @Column(name = "customer_credit_card_expiring_date")
    private Date creditCardExpiringDate;

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
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", loyalityPoints='" + loyalityPoints + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", creditCardExpiringDate=" + creditCardExpiringDate +
                '}';
    }
}
