package pl.sda.orange.java2.event.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.orange.java2.event.entity.Event;
import pl.sda.orange.java2.event.entity.User;
import pl.sda.orange.java2.event.exception.NoSuchEventException;
import pl.sda.orange.java2.event.exception.NoUserFoundException;
import pl.sda.orange.java2.event.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<User> getUserById(Long id){
        Optional<User> user = userRepository.getUserById(id);
        return user.map(
                        value -> ResponseEntity.ok().body(value))
                .orElseThrow(() -> new NoUserFoundException("User not found"));
    }

    public ResponseEntity<User> addUser(User user){
        if(user==null){
            return ResponseEntity.status(400).build();
        }
        userRepository.addUser(user);
        return ResponseEntity.ok().build();
    }
}
