package org.ruzmetov.hotelproject.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RoomTestDto {

    private String roomCategory;

    private double roomPricePerNight;

    private boolean isAvailableRoom;

    private int roomFloor;

    private boolean isBreakfastInclude;

}
