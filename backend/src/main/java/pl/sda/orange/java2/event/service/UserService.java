package pl.sda.orange.java2.event.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.sda.orange.java2.event.dto.RegisterUser;
import pl.sda.orange.java2.event.dto.UserDto;
import pl.sda.orange.java2.event.dto.UserDtoMapper;
import pl.sda.orange.java2.event.entity.Event;
import pl.sda.orange.java2.event.entity.User;
import pl.sda.orange.java2.event.exception.NoSuchEventException;
import pl.sda.orange.java2.event.exception.NoUserFoundException;
import pl.sda.orange.java2.event.exception.PropertyMissingException;
import pl.sda.orange.java2.event.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<UserDto> getUserById(Long id) {

        Optional<User> user = userRepository.getUserById(id);


        return ResponseEntity
                .status(200)
                .body(UserDtoMapper.mapToUserDto(
                        user.orElseThrow(() -> new NoUserFoundException("User not found"))));
    }

    public ResponseEntity<UserDto> addUser(RegisterUser dto) {

        if (dto == null) {
            return ResponseEntity
                    .status(400)
                    .build();
        }

        if (!StringUtils.hasLength(dto.email())) {
            throw new PropertyMissingException("email");
        }

        if(!StringUtils.hasLength(dto.username())){
            throw new PropertyMissingException("username");
        }

        if(userRepository.getUserByEmail(dto.email()).isPresent()){
            return ResponseEntity
                    .status(409)
                    .build();
        }

        var entity = UserDtoMapper.mapToUser(dto);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity = userRepository.addUser(entity);

        return ResponseEntity
                .status(201)
                .body(UserDtoMapper
                        .mapToUserDto(entity));
    }
}
