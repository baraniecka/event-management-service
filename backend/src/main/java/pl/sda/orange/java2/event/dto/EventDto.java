package pl.sda.orange.java2.event.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.sda.orange.java2.event.entity.User;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Setter
@Getter
public class EventDto {

    private Long id;

    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private User host;

    private Set<User> attendees;
}
