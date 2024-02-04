package org.ruzmetov.hotelproject.controller.page;


import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Room;
import org.ruzmetov.hotelproject.service.interf.RoomService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/{id}")  // http://localhost:8080/room/101
    public Room getRoomByRoomId(@PathVariable("id") int id) {
        return roomService.getRoomById(id);
    }

    @DeleteMapping("/delete/{id}") // http://localhost:8080/room/delete/101
    public Room deleteRoomByRoomId(@PathVariable("id") String id) {
        return roomService.deleteRoomById(Integer.parseInt(id));
    }
}
