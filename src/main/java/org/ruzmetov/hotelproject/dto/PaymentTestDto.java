package org.ruzmetov.hotelproject.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTestDto {

    private String paymentMethod;

    private boolean isPaid;

    private String transactionHistory;

}
