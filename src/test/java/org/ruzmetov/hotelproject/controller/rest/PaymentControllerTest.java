package org.ruzmetov.hotelproject.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruzmetov.hotelproject.dto.CustomerTestDto;
import org.ruzmetov.hotelproject.dto.PaymentTestDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/dropTables.sql")
@Sql("/createTestDB.sql")
@Sql("/addTestData.sql")
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postCreatePayment() throws Exception {

        PaymentTestDto paymentTestDto = new PaymentTestDto();
        paymentTestDto.setPaymentMethod("TEST_Credit_Card");
        paymentTestDto.setPaid(true);
        paymentTestDto.setTransactionHistory("TEST_Paid_first_time");

        String payDto = objectMapper.writeValueAsString(paymentTestDto);

        MvcResult createPaymentTestResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/payment/createOnePayment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payDto))
                .andReturn();

        String paymentResultJSON = createPaymentTestResult.getResponse().getContentAsString();
        Payment paymentResult = objectMapper.readValue(paymentResultJSON, Payment.class);

        Assertions.assertEquals(200, createPaymentTestResult.getResponse().getStatus());
        Assertions.assertEquals(paymentTestDto.getPaymentMethod(), paymentResult.getPaymentMethod());
    }
}
