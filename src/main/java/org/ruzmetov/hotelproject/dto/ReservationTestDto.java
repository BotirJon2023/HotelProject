package org.ruzmetov.hotelproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationTestDto {

    private double totalAmount;

    private String cancellationInfo;

}
