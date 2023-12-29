package org.ruzmetov.hotelproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "administrators")
@Entity
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToMany
    @JoinColumn (name = "administrator_id", referencedColumnName = "reservation_administrator_id")
    @JoinColumn (name = "administrator_id", referencedColumnName = "room_administrator_id")
    @JoinColumn (name = "administrator_id", referencedColumnName = "payment_administrator_id")
    @JoinColumn (name = "administrator_id", referencedColumnName = "service_administrator_id")
    @JoinColumn (name = "administrator_id", referencedColumnName = "event_administrator_id")
    @JoinColumn (name = "administrator_id", referencedColumnName = "report_access_administrator_id")
    @JoinColumn (name = "administrator_id", referencedColumnName = "feedback_access_administrator_id")
    @Column(name = "administrator_id")
    private UUID administratorId;

    @Column(name = "administrator_first_name")
    private String firstName;

    @Column(name = "administrator_last_name")
    private String lastName;

    @Column(name = "administrator_password")
    private String password;

    @Column(name = "administrator_email")
    private String email;

    @Column(name = "administrator_departament")
    private String departament;

    @Column(name = "administrator_position")
    private String position;

    @Column(name = "administrator_feedback_review")
    private String feedbackReview;

    @Column(name = "administrator_roots_access")
    private String reportAccess;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(administratorId, that.administratorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(administratorId);
    }

    @Override
    public String toString() {
        return "CommonAdministrator{" +
                "administratorId=" + administratorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", departament='" + departament + '\'' +
                ", position='" + position + '\'' +
                ", feedbackReview='" + feedbackReview + '\'' +
                ", reportAccess='" + reportAccess + '\'' +
                '}';
    }
}
