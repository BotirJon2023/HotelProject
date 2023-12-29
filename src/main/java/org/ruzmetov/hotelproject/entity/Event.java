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
@Table(name = "event")
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToMany
    @JoinColumn(name = "event_id", referencedColumnName = "reservation_event_id")
    @JoinColumn(name = "event_id", referencedColumnName = "customer_event_id")
    @JoinColumn(name = "event_id", referencedColumnName = "feedback_event_id")
    @Column(name = "event_id")
    private UUID eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(name = "event_date")
    private Date date;

    @Column(name = "event_time_beginning")
    private Date eventTimeBeginning;

    @Column(name = "event_time_end")
    private Date eventTimeEnd;

    @Column(name = "event_location")
    private String location;

    @Column(name = "event_capasity")
    private int capacity;

    @Column(name = "event_organized_company")
    private String organizedCompanyName;

    @Column(name = "event_contact_person")
    private String contactPersonName;

    @Column(name = "event_category")
    private String eventCategory;

    @OneToOne
    @JoinColumn(name = "event_total_price", referencedColumnName = "payment_total_amount")
    @Column(name = "event_total_price")
    private double totalPrice;

    @ManyToMany
    @JoinColumn(name = "event_payment_method", referencedColumnName = "payment_method")
    @Column(name = "event_payment_method")
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "event_payment_id", referencedColumnName = "payment_id")
    @Column(name = "event_payment_id")
    private UUID paymentId;

    @ManyToMany
    @JoinColumn (name = "event_employee_id", referencedColumnName = "employee_id")
    @Column(name = "event_employee_id")
    private UUID employeeId;

    @ManyToMany
    @JoinColumn (name = "event_administrator_id", referencedColumnName = "administrator_id")
    @Column(name = "event_administrator_id")
    private String administratorId;

    @Column(name = "event_create")
    private Date eventTabCreate;

    @Column(name = "event_update")
    private Date eventTabUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(eventId, event.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }

    @Override
    public String toString() {
        return "CommenEvent{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", date=" + date +
                ", eventTimeBeginning=" + eventTimeBeginning +
                ", eventTimeEnd=" + eventTimeEnd +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", organizedCompanyName='" + organizedCompanyName + '\'' +
                ", contactPersonName='" + contactPersonName + '\'' +
                ", eventCategory='" + eventCategory + '\'' +
                ", totalPrice=" + totalPrice +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentId=" + paymentId +
                ", employeeId=" + employeeId +
                ", administratorId='" + administratorId + '\'' +
                ", eventTabCreate=" + eventTabCreate +
                ", eventTabUpdate=" + eventTabUpdate +
                '}';
    }
}
