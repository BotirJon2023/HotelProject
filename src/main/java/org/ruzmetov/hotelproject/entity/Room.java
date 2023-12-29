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
@Table (name = "room")
@Entity


public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToMany
    @JoinColumn (name = "room_number", referencedColumnName = "reservation_room_number")
    @JoinColumn (name = "room_number", referencedColumnName = "customer_room_number")
    @JoinColumn (name = "room_number", referencedColumnName = "feedback_room_number")
    private int roomNumber;

    @Column(name = "room_category")
    private String roomCategory;

    @Column(name = "room_ocupancy")
    private int roomMaxOccupancy;

    @Column(name = "room_price_per_night")
    private double roomPricePerNight;

    @ManyToMany
    @JoinColumn(name = "room_total_price", referencedColumnName = "payment_total_amount")
    @Column(name = "room_total_price")
    private double roomTotalPrice;

    @Column(name = "room_availability")
    private boolean isAvailableRoom;

    @Column(name = "room_bed_numbers")
    private int bedNumbers;

    @Column(name = "view_from_room")
    private String viewFromRoom;

    @Column(name = "room_floor")
    private int roomFloor;

    @Column(name = "room_smoking_preferences")
    private String roomSmokingPreferences;

    @Column(name = "room_size")
    private double roomSize;

    @ManyToMany
    @JoinColumn (name = "room_additional_service", referencedColumnName = "service_id")
    @Column(name = "room_additional_service")
    private String roomAdditionallService;

    @Column(name = "room_breakfast_include")
    private boolean isBreakfastInclude;

    @ManyToMany
    @JoinColumn (name = "room_checkIn_date", referencedColumnName = "customer_checkIn_date")
    @Column(name = "room_checkIn_date")
    private Date checkInDate;

    @ManyToMany
    @JoinColumn (name = "room_checkOut_date", referencedColumnName = "customer_checkOut_date")
    @Column(name = "room_checkOut_date")
    private Date checkOutDate;

    @OneToMany
    @JoinColumn (name = "room_employee_id", referencedColumnName = "employee_id")
    @Column(name = "room_employee_id")
    private UUID employeeId;

    @OneToMany
    @JoinColumn (name = "room_administrator_id", referencedColumnName = "administrator_id")
    @Column(name = "room_administrator_id")
    private UUID administratorId;

    @Column(name = "room_tab_create")
    private Date roomTabCreate;

    @Column(name = "room_tab_update")
    private Date roomTabUpdate;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room that = (Room) o;
        return roomNumber == that.roomNumber && roomMaxOccupancy == that.roomMaxOccupancy && roomPricePerNight == that.roomPricePerNight && roomTotalPrice == that.roomTotalPrice && isAvailableRoom == that.isAvailableRoom && bedNumbers == that.bedNumbers && roomFloor == that.roomFloor && Double.compare(roomSize, that.roomSize) == 0 && isBreakfastInclude == that.isBreakfastInclude && Objects.equals(roomCategory, that.roomCategory) && Objects.equals(viewFromRoom, that.viewFromRoom) && Objects.equals(roomSmokingPreferences, that.roomSmokingPreferences) && Objects.equals(roomAdditionallService, that.roomAdditionallService) && Objects.equals(checkInDate, that.checkInDate) && Objects.equals(checkOutDate, that.checkOutDate) && Objects.equals(employeeId, that.employeeId) && Objects.equals(administratorId, that.administratorId) && Objects.equals(roomTabCreate, that.roomTabCreate) && Objects.equals(roomTabUpdate, that.roomTabUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomCategory, roomMaxOccupancy, roomPricePerNight, roomTotalPrice, isAvailableRoom, bedNumbers, viewFromRoom, roomFloor, roomSmokingPreferences, roomSize, roomAdditionallService, isBreakfastInclude, checkInDate, checkOutDate, employeeId, administratorId, roomTabCreate, roomTabUpdate);
    }

    @Override
    public String toString() {
        return "CommonRoom{" +
                "roomNumber=" + roomNumber +
                ", roomCategory='" + roomCategory + '\'' +
                ", roomMaxOccupancy=" + roomMaxOccupancy +
                ", roomPricePerNight=" + roomPricePerNight +
                ", roomTotalPrice=" + roomTotalPrice +
                ", isAvailableRoom=" + isAvailableRoom +
                ", bedNumbers=" + bedNumbers +
                ", viewFromRoom='" + viewFromRoom + '\'' +
                ", roomFloor=" + roomFloor +
                ", roomSmokingPreferences='" + roomSmokingPreferences + '\'' +
                ", roomSize=" + roomSize +
                ", roomAdditionallService='" + roomAdditionallService + '\'' +
                ", isBreakfastInclude=" + isBreakfastInclude +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", employeeId=" + employeeId +
                ", administratorId=" + administratorId +
                ", roomTabCreate=" + roomTabCreate +
                ", roomTabUpdate=" + roomTabUpdate +
                '}';
    }
}