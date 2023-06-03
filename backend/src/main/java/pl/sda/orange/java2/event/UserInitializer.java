package pl.sda.orange.java2.event;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.orange.java2.event.entity.Event;
import pl.sda.orange.java2.event.entity.Role;
import pl.sda.orange.java2.event.entity.User;
import pl.sda.orange.java2.event.repository.IEventRepository;
import pl.sda.orange.java2.event.repository.IUserRepository;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class UserInitializer {

    private final IUserRepository repository;

    @PostConstruct
    void initUsers() {
        User admin = new User("admin@example.com", "secretpass", "admin");
        admin.setRole(Role.ADMIN);
        repository.save(admin);


    }


}
