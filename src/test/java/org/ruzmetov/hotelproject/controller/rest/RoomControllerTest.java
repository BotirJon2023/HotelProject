package org.ruzmetov.hotelproject.controller.rest;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.ruzmetov.hotelproject.dto.RoomTestDto;
//import org.ruzmetov.hotelproject.entity.Room;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@Sql("/dropTables.sql")
//@Sql("/createTestDB.sql")
//@Sql("/addTestData.sql")
//class RoomControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void postCreateRoom() throws Exception {
//
//        RoomTestDto roomTestDto = new RoomTestDto();
//        roomTestDto.setRoomCategory("TEST_Twin_Room");
//        roomTestDto.setRoomPricePerNight(387.99);
//        roomTestDto.setAvailableRoom(true);
//        roomTestDto.setRoomFloor(5);
//        roomTestDto.setBreakfastInclude(true);
//
//        String rooDto = objectMapper.writeValueAsString(roomTestDto);
//
//        MvcResult createRoomTestResult = mockMvc
//                .perform(MockMvcRequestBuilders.post("/room/createOneRoom")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(rooDto))
//                .andReturn();
//
//        String roomResultJSON = createRoomTestResult.getResponse().getContentAsString();
//        Room roomResult = objectMapper.readValue(roomResultJSON, Room.class);
//
//        Assertions.assertEquals(200, createRoomTestResult.getResponse().getStatus());
//        Assertions.assertEquals(roomTestDto.getRoomCategory(), roomResult.getRoomCategory());
//
//    }
//}