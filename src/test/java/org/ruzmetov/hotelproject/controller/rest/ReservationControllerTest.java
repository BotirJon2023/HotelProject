package org.ruzmetov.hotelproject.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruzmetov.hotelproject.dto.PaymentTestDto;
import org.ruzmetov.hotelproject.dto.ReservationTestDto;
import org.ruzmetov.hotelproject.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/dropTables.sql")
@Sql("/createTestDB.sql")
@Sql("/addTestData.sql")
class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postCreateReservation() throws Exception {

        ReservationTestDto reservationTestDto = new ReservationTestDto();
        reservationTestDto.setTotalAmount(412.90);
        reservationTestDto.setCancellationInfo("TEST_Not_Cancelled");

        String reservDto = objectMapper.writeValueAsString(reservationTestDto);

        MvcResult createReservationTestResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/reservation/createOneReservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reservDto))
                .andReturn();

        String reservationResultJSON = createReservationTestResult.getResponse().getContentAsString();
        Reservation reservationResult = objectMapper.readValue(reservationResultJSON, Reservation.class);

        Assertions.assertEquals(200, createReservationTestResult.getResponse().getStatus());
        Assertions.assertEquals(reservationTestDto.getTotalAmount(), reservationResult.getTotalAmount());
    }
}
