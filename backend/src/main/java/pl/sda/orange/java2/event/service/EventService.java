package pl.sda.orange.java2.event.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.orange.java2.event.exception.NoSuchEventException;
import pl.sda.orange.java2.event.model.Event;
import pl.sda.orange.java2.event.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository repository;

    public List<Event> getAllActualEvents(){
        List<Event> events = repository.findAllActualEvents();
        if(events.isEmpty()){
            log.error("Event list is empty");
            throw new NoSuchEventException("No actual events found");
        }
        return events;
    }

    public ResponseEntity<Event> getEvent(Long id){
        Optional<Event> event = repository.getEvent(id);
        return event.map(
                value -> ResponseEntity.ok().body(value))
                .orElseThrow(() -> new NoSuchEventException("Event not found"));

    }
}
