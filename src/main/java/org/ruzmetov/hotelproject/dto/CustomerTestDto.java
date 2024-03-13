package org.ruzmetov.hotelproject.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class CustomerTestDto {

    private String firstName;

    private String lastName;

    private String email;

    private int phoneNumber;

    private String address;

    private String loyalityPoints;

    private String creditCardNumber;

    private Date creditCardExpiringDate;

}
