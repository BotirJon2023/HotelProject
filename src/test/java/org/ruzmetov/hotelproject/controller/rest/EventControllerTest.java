package org.ruzmetov.hotelproject.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruzmetov.hotelproject.dto.EventDto;
import org.ruzmetov.hotelproject.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/dropTables.sql")
@Sql("/createTestDB.sql")
@Sql("/addTestData.sql")
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postCreateEventTest() throws Exception {

        EventDto eventDto = new EventDto();
        eventDto.setEventName("TEST_NAME");
        eventDto.setEventDescription("TEST_MARRIAGE");
        eventDto.setLocation("TEST_Napoleon_CONFERENSE_ROOM");
        eventDto.setCapacity(20);
        eventDto.setOrganizedCompanyName("TEST_Porsche_AG");
        eventDto.setContactPersonName("TEST_Charlie_Chaplin");

        String capDto = objectMapper.writeValueAsString(eventDto);

        MvcResult createEventTestResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/event/createOneEvent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(capDto))
                .andReturn();

        String eventResultJSON = createEventTestResult.getResponse().getContentAsString();
        Event eventResult = objectMapper.readValue(eventResultJSON, Event.class);

        Assertions.assertEquals(200, createEventTestResult.getResponse().getStatus());
        Assertions.assertEquals(eventDto.getEventName(), eventResult.getEventName());
    }
}