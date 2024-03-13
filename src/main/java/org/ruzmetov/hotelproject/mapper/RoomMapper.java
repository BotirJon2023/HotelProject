package org.ruzmetov.hotelproject.mapper;

import org.mapstruct.Mapper;
import org.ruzmetov.hotelproject.dto.EventDto;
import org.ruzmetov.hotelproject.dto.RoomDto;
import org.ruzmetov.hotelproject.dto.RoomTestDto;
import org.ruzmetov.hotelproject.entity.Event;
import org.ruzmetov.hotelproject.entity.Room;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomDto toDTO(Room room);

    Room toEntity(RoomTestDto roomTestDto);


}
