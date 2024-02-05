package org.ruzmetov.hotelproject.service.interf;

import org.ruzmetov.hotelproject.dto.EventUpdateDto;
import org.ruzmetov.hotelproject.entity.Event;

public interface EventService {

    Event getEventById(String id);

    Event createEvent(Event event);

    Event updateEventById(String id, EventUpdateDto eventUpdateDto);
    Event deleteEventById(String id);



}
