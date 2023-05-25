package pl.sda.orange.java2.event.rest_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.orange.java2.event.model.Event;
import pl.sda.orange.java2.event.service.EventService;

import java.util.List;

@RestController
@RequestMapping(path ="/event")
@RequiredArgsConstructor

public class EventController {

    private final EventService service;

    @CrossOrigin
    @GetMapping(path ="/events")
    public List<Event> getAllActualEvents(){
        return service.getAllActualEvents();
    }
}
