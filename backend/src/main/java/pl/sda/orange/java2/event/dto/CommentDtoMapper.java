package pl.sda.orange.java2.event.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.orange.java2.event.entity.Comment;
import pl.sda.orange.java2.event.entity.Event;
import pl.sda.orange.java2.event.repository.EventRepository;


public class CommentDtoMapper {



    public static CommentDto mapToCommentDto(Comment comment) {

        return CommentDto.builder()
                .id(comment.getId())
                .username(comment.getUsername())
                .publishingDate(comment.getPublishingDate())
                .message(comment.getMessage())
                .eventId(comment.getEvent().getId())
                .build();
    }

    public static Comment mapToComment(CommentDto dto,Event event) {

        Comment comment = new Comment();
//        Event event = eventRepository.getEventById(dto.getEventId()).get();

        comment.setId(dto.getId());
        comment.setUsername(dto.getUsername());
        comment.setPublishingDate(dto.getPublishingDate());
        comment.setMessage(dto.getMessage());
        comment.setEvent(event);

        return comment;

    }


}
