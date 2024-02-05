package org.ruzmetov.hotelproject.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.ruzmetov.hotelproject.entity.Reservation;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDtoReservations {


    private String firstName;

    private String lastName;

    private String email;

    private int phoneNumber;

    private String address;

    private String loyalityPoints;

    private int creditCardNumber;

    private Date creditCardExpiringDate;

    private Set<ReservationDto> reservations;


}
