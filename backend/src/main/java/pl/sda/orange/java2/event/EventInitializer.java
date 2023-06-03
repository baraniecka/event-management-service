package pl.sda.orange.java2.event;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.orange.java2.event.entity.Event;
import pl.sda.orange.java2.event.repository.IEventRepository;

import java.time.LocalDate;
@Component
@RequiredArgsConstructor
public class EventInitializer {

    private final IEventRepository repository;

    @PostConstruct
    void initEvents() {
        repository.save(new Event("bob's birthday", LocalDate.of(2023, 7, 25), LocalDate.of(2023, 7, 26),
                "dear bob's 16 birthday party, please bring your own drinks. dogs are allowed. remember to inform about your allergies - meg's responsible for food"));
        repository.save(new Event("lou and beth anniversary party", LocalDate.of(2023, 6, 21), LocalDate.of(2023, 6, 22),
                "dear bob's 16 birthday party, please bring your own drinks. dogs are allowed. remember to inform about your allergies - meg's responsible for food"));
        repository.save(new Event("Swider river walking", LocalDate.of(2023, 7, 29), LocalDate.of(2023, 7, 29),
                "morning walk through Swider river. starting from Swider railway station. don't forget your sunscreen and swimsuit!"));
        repository.save(new Event("board game night with othello", LocalDate.of(2023, 6, 10), LocalDate.of(2023, 6, 11),
                "meet great board game of othello! similar to chess and go, you can learn it in a minute and master in a lifetime. tell your neighbour about the event."));
    }


}
