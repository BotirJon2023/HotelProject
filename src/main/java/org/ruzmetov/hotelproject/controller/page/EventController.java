package org.ruzmetov.hotelproject.controller.page;


import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Event;
import org.ruzmetov.hotelproject.service.interf.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor

public class EventController {


    private final EventService eventService;


    @GetMapping("/{id}") // http://localhost:8080/event/9b2e1522-5658-4555-8cb8-acb5de2fefef
    public Event getEventByEventId(@PathVariable("id") String id) {

        return eventService.getEventById(id);
    }

}
