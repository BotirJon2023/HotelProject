package org.ruzmetov.hotelproject.mapper;

import org.mapstruct.Mapper;
import org.ruzmetov.hotelproject.dto.EventDto;
import org.ruzmetov.hotelproject.entity.Event;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDto toDTO(Event event);

    Event toEntity(EventDto eventDto);

    List<EventDto> eventsToEventDto(List<Event> events);

}
