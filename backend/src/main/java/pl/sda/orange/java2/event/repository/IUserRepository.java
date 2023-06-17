package pl.sda.orange.java2.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.orange.java2.event.entity.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);
}
