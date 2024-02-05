package org.ruzmetov.hotelproject.service.interf;

import org.ruzmetov.hotelproject.dto.RoomUpdateDto;
import org.ruzmetov.hotelproject.entity.Reservation;
import org.ruzmetov.hotelproject.entity.Room;

public interface RoomService {

    Room getRoomById(int id);

    Room createRoom(Room room);

    Room updateRoomById(int id, RoomUpdateDto roomUpdateDto);

    Room deleteRoomById(int id);


}
