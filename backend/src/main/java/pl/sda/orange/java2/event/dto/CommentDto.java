package pl.sda.orange.java2.event.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long id;
    private String message;
    private LocalDate publishingDate;
    private String username;
    private Long eventId;

}