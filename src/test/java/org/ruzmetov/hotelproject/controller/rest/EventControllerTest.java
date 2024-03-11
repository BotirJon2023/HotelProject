package org.ruzmetov.hotelproject.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruzmetov.hotelproject.dto.EventDto;
import org.ruzmetov.hotelproject.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
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
@Sql("/createTestDB.xml")
@Sql("/addTestData.xml")
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postCreateEventTest() throws Exception {

        EventDto eventDto = new EventDto();
        eventDto.setEventName("TEST_NAME");
        eventDto.setCapacity(20);

        String capDto = objectMapper.writeValueAsString(eventDto);

        MvcResult createEventTestResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/event/createOneEvent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(capDto))
                .andReturn();

        String eventResultJSON = createEventTestResult.getResponse().getContentAsString();
        Event eventResult = objectMapper.readValue(eventResultJSON, Event.class);

        Assertions.assertEquals(201, createEventTestResult.getResponse().getStatus());
        Assertions.assertEquals(eventDto.getEventName(), eventResult.getEventName());
    }
}