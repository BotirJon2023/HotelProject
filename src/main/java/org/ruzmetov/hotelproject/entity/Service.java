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
@Table (name = "service")
@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private UUID serviceId;

    @Column(name = "service_breakfast_booking")
    private boolean isBeakfastBooked;

    @Column(name = "service_breakfast_price")
    private double serviceBreakfastPrice;

    @Column(name = "service_restaurant_booking")
    private boolean isRestaurantBooked;

    @Column(name = "service_restaurant_price")
    private double serviceRestaurantPrice;

    @Column(name = "service_bar_booking")
    private boolean isBarBooked;

    @Column(name = "service_bar_price")
    private double serviceBarPrice;

    @Column(name = "service_swimming_pool_booking")
    private boolean isSwimmingPoolBooked;

    @Column(name = "service_swimming_pool_price")
    private double serviceSwimmingPoolPrice;

    @Column(name = "service_gym_booking")
    private boolean IsGymBooked;

    @Column(name = "service_gym_price")
    private double serviceGymPrice;

    @Column(name = "service_garage_booking")
    private boolean isGarageBooked;

    @Column(name = "service_garage_price")
    private double serviceGaragePrice;

    @Column(name = "service_airport_transfer")
    private boolean isAirportTransferBooked;

    @Column(name = "service_airport_transfer_price")
    private double serviceAirportTransferPrice;

    @Column(name = "service_create")
    private Date serviceTabCreate;

    @Column(name = "service_update")
    private Date serviceTabUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(serviceId, service.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId);
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", isBeakfastBooked=" + isBeakfastBooked +
                ", serviceBreakfastPrice=" + serviceBreakfastPrice +
                ", isRestaurantBooked=" + isRestaurantBooked +
                ", serviceRestaurantPrice=" + serviceRestaurantPrice +
                ", isBarBooked=" + isBarBooked +
                ", serviceBarPrice=" + serviceBarPrice +
                ", isSwimmingPoolBooked=" + isSwimmingPoolBooked +
                ", serviceSwimmingPoolPrice=" + serviceSwimmingPoolPrice +
                ", IsGymBooked=" + IsGymBooked +
                ", serviceGymPrice=" + serviceGymPrice +
                ", isGarageBooked=" + isGarageBooked +
                ", serviceGaragePrice=" + serviceGaragePrice +
                ", isAirportTransferBooked=" + isAirportTransferBooked +
                ", serviceAirportTransferPrice=" + serviceAirportTransferPrice +
                ", serviceTabCreate=" + serviceTabCreate +
                ", serviceTabUpdate=" + serviceTabUpdate +
                '}';
    }
}
