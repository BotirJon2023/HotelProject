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
@Table(name = "event")
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id", columnDefinition = "UUID")
    @JdbcTypeCode(SqlTypes.CHAR)
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

    @Column(name = "event_capacity")
    private int capacity;

    @Column(name = "event_organized_company")
    private String organizedCompanyName;

    @Column(name = "event_contact_person")
    private String contactPersonName;

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
        return "Event{" +
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
                '}';
    }
}

