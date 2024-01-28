package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Event;
import org.ruzmetov.hotelproject.repository.EventRepository;
import org.ruzmetov.hotelproject.service.interf.EventService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event getAccById(String id) {

        return eventRepository.getEventByEventId(UUID.fromString(id));
    }
}

