package org.ruzmetov.hotelproject.repository;

import org.ruzmetov.hotelproject.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

    Event findEventByEventId(UUID id);

}

