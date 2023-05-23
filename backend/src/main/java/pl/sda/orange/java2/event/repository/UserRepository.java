package pl.sda.orange.java2.event.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.orange.java2.event.model.Event;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final IEventRepository repository;

    public List<Event> getAllEvents(){
        return repository.findAll();
    }
}
