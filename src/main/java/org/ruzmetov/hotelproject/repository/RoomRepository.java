package org.ruzmetov.hotelproject.repository;

import org.ruzmetov.hotelproject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    Room getRoomByRoomNumber(Integer roomNumber);

}
