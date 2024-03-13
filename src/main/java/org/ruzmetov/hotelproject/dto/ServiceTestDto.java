package org.ruzmetov.hotelproject.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ServiceTestDto {

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
