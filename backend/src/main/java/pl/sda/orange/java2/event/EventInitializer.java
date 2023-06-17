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
        repository.save(new Event("bob's birthday", LocalDate.now().plusDays(10), LocalDate.now().plusDays(11),
                "dear bob's 16 birthday party, please bring your own drinks. dogs are allowed. remember to inform about your allergies - meg's responsible for food"));
        repository.save(new Event("lou and beth anniversary party", LocalDate.now().plusDays(12), LocalDate.now().plusDays(13),
                "dear bob's 16 birthday party, please bring your own drinks. dogs are allowed. remember to inform about your allergies - meg's responsible for food"));
        repository.save(new Event("Swider river walking", LocalDate.now().plusDays(20), LocalDate.now().plusDays(21),
                "morning walk through Swider river. starting from Swider railway station. don't forget your sunscreen and swimsuit!"));
        repository.save(new Event("board game night with othello", LocalDate.now().plusDays(25), LocalDate.now().plusDays(26),
                "meet great board game of othello! similar to chess and go, you can learn it in a minute and master in a lifetime. tell your neighbour about the event."));
    }


}
