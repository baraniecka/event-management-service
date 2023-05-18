package pl.sda.orange.java2.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.orange.java2.event.model.Event;

public interface IEventRepository extends JpaRepository<Event, Long> {
}
