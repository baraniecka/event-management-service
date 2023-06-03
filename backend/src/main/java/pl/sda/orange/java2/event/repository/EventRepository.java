package pl.sda.orange.java2.event.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.orange.java2.event.entity.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EventRepository {


    private final IEventRepository repository;

    public List<Event> findAllActualEvents(){
        LocalDate actualDate = LocalDate.now();
       return repository.findAllActualEvents(actualDate);
    }

    public Optional<Event> getEvent(Long id){
        return repository.findById(id);
    }

    public Event addEvent(Event event){
        return repository.save(event);
    }
}
