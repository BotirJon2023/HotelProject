package org.ruzmetov.hotelproject.service.interf;

import org.ruzmetov.hotelproject.entity.Room;

public interface RoomService {

    Room getRoomById(int id);

    Room deleteRoomById(int id);
}
