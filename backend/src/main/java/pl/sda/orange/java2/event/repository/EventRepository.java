package pl.sda.orange.java2.event.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.orange.java2.event.model.Event;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventRepository {


    private final IEventRepository repository;

    public List<Event> findAllActualEvents(){
        LocalDate actualDate = LocalDate.now();
       return repository.findAllActualEvents(actualDate);
    }

}
