package org.ruzmetov.hotelproject.controller.page;


import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Room;
import org.ruzmetov.hotelproject.service.interf.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor

public class RoomController {

    private final RoomService roomService;

    @GetMapping("/{id}")
    public Room getAccountById(@PathVariable("id") String id) {
        return roomService.getAccById(id);

    }


}
