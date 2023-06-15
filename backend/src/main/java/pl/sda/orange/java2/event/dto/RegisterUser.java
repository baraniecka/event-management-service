package pl.sda.orange.java2.event.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RegisterUser(
        @Email String email,
        @Length(min = 8, max = 30) String password,
        @NotBlank
        @Length(max = 50) String username) {
}
