package pl.sda.orange.java2.event.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class CommentDto {

    private Long id;
    private String message;
    private LocalDate publishingDate;
    private String username;
    private Long eventId;

}