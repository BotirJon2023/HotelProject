package org.ruzmetov.hotelproject.controller.page;


import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.ReservationUpdateDto;
import org.ruzmetov.hotelproject.dto.RoomUpdateDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Reservation;
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

    @PostMapping("/createOneRoom")  // http://localhost:8080/room/createOneRoom
    @ResponseBody
    public Room postCreateRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @PutMapping("/updateOneRoom/{id}")
    // http://localhost:8080/room/updateOneRoom/101
    public Room updateRoomByRoomId(@PathVariable(value = "id") int id, @RequestBody RoomUpdateDto roomUpdateDto) {
        return roomService.updateRoomById(id, roomUpdateDto);
    }

    @DeleteMapping("/delete/{id}") // http://localhost:8080/room/delete/101
    public Room deleteRoomByRoomId(@PathVariable("id") String id) {
        return roomService.deleteRoomById(Integer.parseInt(id));
    }
}
