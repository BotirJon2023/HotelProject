package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Room;
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
    public Room deleteRoomById(int id) {
        return roomRepository.deleteRoomByRoomId(id);
    }
}
