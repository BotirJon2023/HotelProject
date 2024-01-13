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


//    private final EventService eventService;

//    public EventController(EventService eventService) {
//        this.eventService = eventService;
//    }

    @GetMapping("/{id}")
    public Event getAccountById(@PathVariable("id") String id) {
        // return eventService.getAccountById(id);
        return null;
    }


}
