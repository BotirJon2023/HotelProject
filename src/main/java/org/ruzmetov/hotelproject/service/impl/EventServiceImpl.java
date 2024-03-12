package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.EventDto;
import org.ruzmetov.hotelproject.dto.EventUpdateDto;
import org.ruzmetov.hotelproject.entity.Event;
import org.ruzmetov.hotelproject.exception.EventNotFoundException;
import org.ruzmetov.hotelproject.mapper.EventMapper;
import org.ruzmetov.hotelproject.repository.EventRepository;
import org.ruzmetov.hotelproject.service.interf.EventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Event getEventById(String id) {
        return eventRepository.findEventByEventId(UUID.fromString(id));
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Event createEvent(EventDto eventDto) {
        return eventRepository.save(eventMapper.toEntity(eventDto));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Event updateEventById(String id, EventUpdateDto eventUpdateDto) {
        Event event = eventRepository.findById(UUID.fromString(id)).orElseThrow(() -> new EventNotFoundException("Event with this id not found!"));
        event.setEventName(eventUpdateDto.getEventName());
        event.setEventDescription(eventUpdateDto.getEventDescription());
        event.setEventTimeBeginning(eventUpdateDto.getEventTimeBeginning());
        event.setEventTimeEnd(eventUpdateDto.getEventTimeEnd());
        event.setCapacity(eventUpdateDto.getCapacity());
        event.setOrganizedCompanyName(eventUpdateDto.getOrganizedCompanyName());
        event.setContactPersonName(eventUpdateDto.getContactPersonName());
        return eventRepository.save(event);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Event deleteEventById(String id) {
        return eventRepository.deleteEventByEventId(UUID.fromString(id));
    }
}
