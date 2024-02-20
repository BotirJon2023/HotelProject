package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.RoomUpdateDto;
import org.ruzmetov.hotelproject.entity.Room;
import org.ruzmetov.hotelproject.exception.RoomNotFoundException;
import org.ruzmetov.hotelproject.repository.RoomRepository;
import org.ruzmetov.hotelproject.service.interf.RoomService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public Room getRoomById(int id) {
        return roomRepository.findRoomByRoomId(id);
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoomById(int id, RoomUpdateDto roomUpdateDto) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException("Room with this number not found!"));
        room.setRoomCategory(roomUpdateDto.getRoomCategory());
        room.setRoomPricePerNight(roomUpdateDto.getRoomPricePerNight());
        room.setAvailableRoom(roomUpdateDto.isAvailableRoom());
        room.setCheckInDate(roomUpdateDto.getCheckInDate());
        room.setCheckOutDate(roomUpdateDto.getCheckOutDate());
        return roomRepository.save(room);
    }

    @Override
    public Room deleteRoomById(int id) {
        return roomRepository.deleteRoomByRoomId(id);
    }
}
