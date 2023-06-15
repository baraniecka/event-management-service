package pl.sda.orange.java2.event.dto;

import pl.sda.orange.java2.event.entity.User;

public class UserDtoMapper {

    public static UserDto mapToUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    public static User mapToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setRole(userDto.getRole());
        return user;
    }

    public static User mapToUser(RegisterUser userDto){
        User user = new User();

        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setUsername(userDto.username());

        return user;
    }
}
