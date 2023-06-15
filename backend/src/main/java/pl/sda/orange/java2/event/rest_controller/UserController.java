package pl.sda.orange.java2.event.rest_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.sda.orange.java2.event.dto.RegisterUser;
import pl.sda.orange.java2.event.dto.UserDto;
import pl.sda.orange.java2.event.service.UserService;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/{id}")
    public UserDto showUser(@PathVariable Long id) {
        return userService.getUserById(id).getBody();
    }

    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@Validated @RequestBody RegisterUser userDto){
            return userService.addUser(userDto);

    }

}
