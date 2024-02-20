package org.ruzmetov.hotelproject.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ServiceUpdateDto {

    private boolean isBeakfastBooked;

    private double serviceBreakfastPrice;

    private boolean isRestaurantBooked;

    private double serviceRestaurantPrice;

    private boolean isBarBooked;

    private double serviceBarPrice;

    private boolean isSwimmingPoolBooked;

    private double serviceSwimmingPoolPrice;

    private boolean IsGymBooked;

    private double serviceGymPrice;

    private boolean isGarageBooked;

    private double serviceGaragePrice;

    private boolean isAirportTransferBooked;

    private double serviceAirportTransferPrice;

}