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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id", columnDefinition = "integer")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int roomId;

    @Column(name = "room_category")
    private String roomCategory;

    @Column(name = "room_price_per_night")
    private double roomPricePerNight;

    @Column(name = "room_availability")
    private boolean isAvailableRoom;

    @Column(name = "room_floor")
    private int roomFloor;

    @Column(name = "room_breakfast_include")
    private boolean isBreakfastInclude;

    @Column(name = "room_checkIn_date")
    private Date checkInDate;

    @Column(name = "room_checkOut_date")
    private Date checkOutDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomId == room.roomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomCategory='" + roomCategory + '\'' +
                ", roomPricePerNight=" + roomPricePerNight +
                ", isAvailableRoom=" + isAvailableRoom +
                ", roomFloor=" + roomFloor +
                ", isBreakfastInclude=" + isBreakfastInclude +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}

