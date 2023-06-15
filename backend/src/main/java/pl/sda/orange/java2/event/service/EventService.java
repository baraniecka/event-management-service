package pl.sda.orange.java2.event.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.orange.java2.event.dto.EventDto;
import pl.sda.orange.java2.event.dto.EventDtoMapper;
import pl.sda.orange.java2.event.entity.Event;
import pl.sda.orange.java2.event.entity.User;
import pl.sda.orange.java2.event.exception.EventAlreadyExistsException;
import pl.sda.orange.java2.event.exception.NoSuchEventException;
import pl.sda.orange.java2.event.repository.EventRepository;
import pl.sda.orange.java2.event.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public ResponseEntity<List<EventDto>> getAllActualEvents(){
        List<Event> events = eventRepository.findAllActualEvents();

        if(events.isEmpty()){
            log.error("Event list is empty");
            return ResponseEntity
                    .status(404)
                    .build();
        }
        return ResponseEntity
                .status(200)
                .body(events.stream()
                        .map(event -> EventDtoMapper.mapToEventDto(event))
                        .collect(Collectors.toList()));
    }

    public ResponseEntity<EventDto> getEvent(Long id){

        Optional<Event> event = eventRepository.getEventById(id);

        return ResponseEntity
                .status(200)
                .body(EventDtoMapper.mapToEventDto(
                        event.orElseThrow(() -> new NoSuchEventException("Event not found"))));

    }


    //TODO: verification if event already exists
    public ResponseEntity<EventDto> addEvent(EventDto eventDto){
           /*Steps:
        - check if user is logged - security, page with authentication
        - check if event already exists in database - how?
        - user get EVENT_HOST role
        - user linked with an event
        - save event in database
         */

//        user.setRole(Role.EVENT_HOST);

        if (eventDto == null) {
            throw new NoSuchEventException("Event cannot be null");
        }

        if(eventRepository.getEventByTitleAndStartDate(
                eventDto.getTitle(), eventDto.getStartDate()).isPresent()){
            throw new EventAlreadyExistsException("Event already exists");
        }

        User host = userRepository.getAdmin();
        eventDto.setHost(host);

        return ResponseEntity
                .status(201)
                .body(EventDtoMapper.mapToEventDto
                        (eventRepository.addEvent(EventDtoMapper.mapToEvent(eventDto))));
    }
}
