package pl.sda.orange.java2.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.orange.java2.event.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {

User findUserByUsername(String username);
}
