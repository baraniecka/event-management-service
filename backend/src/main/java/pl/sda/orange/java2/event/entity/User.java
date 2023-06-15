package pl.sda.orange.java2.event.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    private String password;

    @NotBlank
    @Length(max = 50)
    private String username;

    @Enumerated(EnumType.STRING)
    private Role role = Role.REGULAR_USER;

    @OneToMany(mappedBy = "host", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Event> hostedEvents;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "event_attendees",
            joinColumns = {
                    @JoinColumn(name = "user_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "event_id")
            }
    )
    private Set<Event> userEvents;


    public User(Long id, String email, String password, String username, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public User(String email, String password, String username, Role role) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}

//http basic
//token
