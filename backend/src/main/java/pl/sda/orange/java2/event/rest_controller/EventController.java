package pl.sda.orange.java2.event.rest_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sda.orange.java2.event.entity.Event;
import pl.sda.orange.java2.event.service.EventService;

import java.util.List;

@RestController
@RequestMapping(path = "/event")
@RequiredArgsConstructor
@CrossOrigin
public class EventController {

    private final EventService eventService;



    @GetMapping(path = "/events")
    public List<Event> getAllActualEvents() {
        return eventService.getAllActualEvents();
    }

    @GetMapping(path = "/{id}")
    public Event getEvent(@PathVariable Long id) {
        return eventService.getEvent(id).getBody();
    }

    @PostMapping()
    public void addEvent(@RequestBody Event event) {

        eventService.addEvent(event);
    }
}
