package org.ruzmetov.hotelproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerUpdateDto {

    private String firstName;

    private String lastName;

    private String email;

    private int phoneNumber;

    private String address;
}