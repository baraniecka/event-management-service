package pl.sda.orange.java2.event.rest_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sda.orange.java2.event.model.Event;
import pl.sda.orange.java2.event.service.EventService;

import java.util.List;

@RestController
@RequestMapping(path = "/event")
@RequiredArgsConstructor
@CrossOrigin
public class EventController {

    private final EventService service;


    @GetMapping(path = "/events")
    public List<Event> getAllActualEvents() {
        return service.getAllActualEvents();
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
        return service.getEvent(id).getBody();
    }
}
