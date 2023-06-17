package pl.sda.orange.java2.event.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.orange.java2.event.dto.CommentDto;
import pl.sda.orange.java2.event.dto.CommentDtoMapper;
import pl.sda.orange.java2.event.entity.Comment;
import pl.sda.orange.java2.event.entity.Event;
import pl.sda.orange.java2.event.exception.CommentNotFoundException;
import pl.sda.orange.java2.event.repository.CommentRepository;
import pl.sda.orange.java2.event.repository.EventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final EventRepository eventRepository;


    public ResponseEntity<List<CommentDto>> getComments(Long id) {
        List<Comment> comments = commentRepository.findCommentWithEventId(id);

        if (comments.isEmpty()) {
            return ResponseEntity
                    .status(404)
//                    .body("No comments added yet.")
                    .build();
        }

        return ResponseEntity
                .status(200)
                .body(comments
                        .stream()
                        .map(comment -> CommentDtoMapper.mapToCommentDto(comment))
                        .collect(Collectors.toList()));
    }

    public ResponseEntity<CommentDto> addComment(CommentDto dto) {

        if(dto == null){
            throw new CommentNotFoundException("Comment cannot be null");
        }

        Event event = eventRepository.getEventById(dto.getEventId()).get();
        Comment comment = CommentDtoMapper.mapToComment(dto,event);


        return ResponseEntity
                .status(201)
                .body(CommentDtoMapper.mapToCommentDto(commentRepository.save(comment)));
    }
}
