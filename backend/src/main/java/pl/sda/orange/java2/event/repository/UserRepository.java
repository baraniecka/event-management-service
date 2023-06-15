package pl.sda.orange.java2.event.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.orange.java2.event.entity.User;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final IUserRepository repository;

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public User addUser(User user){
        return repository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {

        return repository.findUserByEmail(email);

    }

    public User getAdmin() {
        return repository.findUserByUsername("admin");
    }
}

