package com.capgemini.codingnight.controller;

import com.capgemini.codingnight.model.Event;
import com.capgemini.codingnight.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HSMILDE on 15-5-2017.test
 */
@RestController
public class EventController {

    private List<Event> eventList = new ArrayList<>();

    @Autowired
    private EventsRepository eventsRepository;

    @GetMapping("/event")
    public List<Event> getEvents() throws URISyntaxException {
        return eventsRepository.getAllEvents();
    }

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable Long id) {
        for (Event event : eventList){
            if (event.getId() == id){
                return event;
            }
        }
        return null;
    }

    @PostMapping("/event")
    public void postEvent(@RequestBody(required = false) Event event) {
        if (event != null) {
            System.out.println("post event");
            eventList.add(event);
        } else {
            System.out.println("post empty event");
        }
    }
}
