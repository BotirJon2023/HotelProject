package org.ruzmetov.hotelproject.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruzmetov.hotelproject.dto.CustomerDto;
import org.ruzmetov.hotelproject.dto.CustomerTestDto;
import org.ruzmetov.hotelproject.dto.EventDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Event;
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
class CustomerControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postCreateCustomer() throws Exception {

        CustomerTestDto customerTestDto = new CustomerTestDto();
        customerTestDto.setFirstName("TEST_ARNOLD");
        customerTestDto.setLastName("TEST_SCHWARZENEGGER");
        customerTestDto.setEmail("TETS_arny_schwarz@gmail.com");
        customerTestDto.setPhoneNumber(1234567);
        customerTestDto.setAddress("Holleywoodheels 456, 12345 CA, USA");
        customerTestDto.setLoyalityPoints("TEST_DIAMOND");
        customerTestDto.setCreditCardNumber("1234356");

        String cusDto = objectMapper.writeValueAsString(customerTestDto);

        MvcResult createCustomerTestResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/customer/createOneCustomer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cusDto))
                .andReturn();

        String customerResultJSON = createCustomerTestResult.getResponse().getContentAsString();
        Customer customerResult = objectMapper.readValue(customerResultJSON, Customer.class);

        Assertions.assertEquals(200, createCustomerTestResult.getResponse().getStatus());
        Assertions.assertEquals(customerTestDto.getFirstName(), customerResult.getFirstName());
    }

}