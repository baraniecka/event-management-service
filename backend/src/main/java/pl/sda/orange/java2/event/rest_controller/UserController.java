package pl.sda.orange.java2.event.rest_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.orange.java2.event.entity.User;
import pl.sda.orange.java2.event.repository.IUserRepository;
import pl.sda.orange.java2.event.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final IUserRepository userRepository;

    @GetMapping(path = "/{id}")
    public User showUser(@PathVariable Long id) {
        return userService.getUserById(id).getBody();
    }

    @PostMapping("/add")
    public ResponseEntity addUser(User user){
        return userService.addUser(user);
    }

    public User getAdmin() {
        return userRepository.findUserByUsername("admin");
    }

//    public Long getAdminId(){
//        return getAdmin().getId();
//    }

}
