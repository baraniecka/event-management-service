package pl.sda.orange.java2.event.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.orange.java2.event.exception.NoSuchEventException;
import pl.sda.orange.java2.event.entity.Event;
import pl.sda.orange.java2.event.entity.Role;
import pl.sda.orange.java2.event.entity.User;
import pl.sda.orange.java2.event.repository.EventRepository;
import pl.sda.orange.java2.event.rest_controller.UserController;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository repository;
    private final UserController userController;

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


    //TODO: verification if event already exists
    public Event addEvent(Event event){
           /*Steps:
        - check if user is logged - security, page with authentication
        - check if event already exists in database - how?
        - user get EVENT_HOST role
        - user linked with an event
        - save event in database
         */

//        user.setRole(Role.EVENT_HOST);
        User host = userController.getAdmin();
        event.setHost(host);
        return repository.addEvent(event);
    }
}
