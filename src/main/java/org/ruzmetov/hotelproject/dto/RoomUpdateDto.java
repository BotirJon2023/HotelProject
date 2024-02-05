package org.ruzmetov.hotelproject.dto;

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

public class RoomUpdateDto {

    private String roomCategory;

    private double roomPricePerNight;

    private boolean isAvailableRoom;

    private Date checkInDate;

    private Date checkOutDate;

}

