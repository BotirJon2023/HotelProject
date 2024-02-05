package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.EventUpdateDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Event;
import org.ruzmetov.hotelproject.exeption.CustomerNotFoundException;
import org.ruzmetov.hotelproject.exeption.EventNotFoundException;
import org.ruzmetov.hotelproject.repository.EventRepository;
import org.ruzmetov.hotelproject.service.interf.EventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event getEventById(String id) {
        return eventRepository.findEventByEventId(UUID.fromString(id));
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    @Transactional
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
    public Event deleteEventById(String id) {
        return eventRepository.deleteEventByEventId(UUID.fromString(id));
    }
}
