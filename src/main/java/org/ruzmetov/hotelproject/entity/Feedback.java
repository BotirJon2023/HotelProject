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
@Table(name = "feedback")
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToMany
    @JoinColumn(name = "feedback_id", referencedColumnName = "employee_feedback")
    @Column(name = "feedback_id")
    private UUID feedbackId;

    @ManyToMany
    @JoinColumn(name = "feedback_room_number", referencedColumnName = "room_number")
    @Column(name = "feedback_room_number")
    private int roomNumber;

    @ManyToMany
    @JoinColumn(name = "feedback_service_id", referencedColumnName = "service_id")
    @Column(name = "feedback_service_id")
    private UUID serviceId;

    @ManyToMany
    @JoinColumn(name = "feedback_event_id", referencedColumnName = "event_id")
    @Column(name = "feedback_event_id")
    private UUID eventId;

    @Column(name = "feedback_satisfaction_rating_from_1_to_5")
    private int satisfactionRating;

    @Column(name = "feedback_comments")
    private String comments;

    @ManyToMany
    @JoinColumn (name = "feedback_customer_first_name", referencedColumnName = "customer_first_name")
    @Column(name = "feedback_customer_first_name")
    private String customerFirstName;

    @ManyToMany
    @JoinColumn (name = "feedback_customer_last_name", referencedColumnName = "customer_last_name")
    @Column(name = "feedback_customer_last_name")
    private String customerLastName;

    @ManyToMany
    @JoinColumn (name = "feedback_access_administrator_id", referencedColumnName = "administrator_id")
    @Column(name = "feedback_access_administrator_id")
    private UUID accessAdministratorId;

    @Column(name = "feedback_create")
    private Date feedbackTabCreate;

    @Column(name = "feedback_update")
    private Date feedbackTabUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(feedbackId, feedback.feedbackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackId);
    }

    @Override
    public String toString() {
        return "CommonFeedback{" +
                "feedbackId=" + feedbackId +
                ", roomNumber=" + roomNumber +
                ", serviceId=" + serviceId +
                ", eventId=" + eventId +
                ", satisfactionRating=" + satisfactionRating +
                ", comments='" + comments + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", accessAdministratorId=" + accessAdministratorId +
                ", feedbackTabCreate=" + feedbackTabCreate +
                ", feedbackTabUpdate=" + feedbackTabUpdate +
                '}';
    }
}
