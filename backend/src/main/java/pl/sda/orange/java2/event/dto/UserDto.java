package pl.sda.orange.java2.event.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import pl.sda.orange.java2.event.entity.Event;
import pl.sda.orange.java2.event.entity.Role;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
public class UserDto {

    private Long id;

    private String email;

    private String password;

    private String username;

    private Role role;

    @JsonIgnore
    private Set<Event> hostedEvents;

    private Set<Event> userEvents;
}
