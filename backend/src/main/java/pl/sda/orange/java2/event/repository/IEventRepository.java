package pl.sda.orange.java2.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.orange.java2.event.entity.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IEventRepository extends JpaRepository<Event, Long> {

    @Query(value = "FROM Event e WHERE e.endDate > :dateNow ORDER BY e.startDate")
    List<Event> findAllActualEvents(@Param("dateNow") LocalDate date);

    Optional<Event> findEventByTitleAndStartDate(String title, LocalDate start);

}
