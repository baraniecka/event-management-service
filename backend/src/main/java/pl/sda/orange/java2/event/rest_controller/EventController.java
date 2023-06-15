package pl.sda.orange.java2.event.rest_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.orange.java2.event.dto.EventDto;
import pl.sda.orange.java2.event.entity.Event;
import pl.sda.orange.java2.event.service.EventService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
@CrossOrigin
public class EventController {

    private final EventService eventService;



    @GetMapping(path = "/events")
    public ResponseEntity<List<EventDto>> getAllActualEvents() {
        return eventService.getAllActualEvents();
    }

    @GetMapping(path = "/event/{id}")
    public ResponseEntity<EventDto> getEvent(@PathVariable Long id) {
        return eventService.getEvent(id);
    }

    @PostMapping(path = "/event")
    public ResponseEntity<EventDto> addEvent(@RequestBody EventDto eventDto) {

        return eventService.addEvent(eventDto);
    }
}
