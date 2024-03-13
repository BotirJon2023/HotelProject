package org.ruzmetov.hotelproject.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruzmetov.hotelproject.dto.CustomerTestDto;
import org.ruzmetov.hotelproject.dto.ServiceTestDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Service;
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
class ServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postCreateService() throws Exception {

        ServiceTestDto serviceTestDto = new ServiceTestDto();
        serviceTestDto.setRestaurantBooked(true);
        serviceTestDto.setServiceRestaurantPrice(46.79);
        serviceTestDto.setBarBooked(true);
        serviceTestDto.setServiceBarPrice(77.99);
        serviceTestDto.setSwimmingPoolBooked(true);
        serviceTestDto.setServiceSwimmingPoolPrice(23.00);
        serviceTestDto.setIsGymBooked(true);
        serviceTestDto.setServiceGymPrice(17.99);
        serviceTestDto.setGarageBooked(true);
        serviceTestDto.setServiceGaragePrice(25.00);
        serviceTestDto.setAirportTransferBooked(true);
        serviceTestDto.setServiceAirportTransferPrice(299.99);


        String servDto = objectMapper.writeValueAsString(serviceTestDto);

        MvcResult createServiceTestResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/service/createOneService")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(servDto))
                .andReturn();

        String serviceResultJSON = createServiceTestResult.getResponse().getContentAsString();
        Service serviceResult = objectMapper.readValue(serviceResultJSON, Service.class);

        Assertions.assertEquals(200, createServiceTestResult.getResponse().getStatus());
        Assertions.assertEquals(serviceTestDto.getServiceRestaurantPrice(), serviceResult.getServiceRestaurantPrice());
    }
}
