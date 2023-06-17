package pl.sda.orange.java2.event.rest_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.orange.java2.event.dto.CommentDto;
import pl.sda.orange.java2.event.entity.Comment;
import pl.sda.orange.java2.event.service.CommentService;

import java.util.List;

@RestController
@RequestMapping(path ="/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping(path = "/comment/event/{id}")
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable Long id){

        return commentService.getComments(id);
        /*
        1. lista komentarzy dla danego eventu
        2. zapytanie dla Comment, gdzie event id = id
        3. jeśli nie ma komentarzy -> komunikat "Nikt nie skomentował. Dodaj komentarz" -> z przezkierowaniem na dodawanie komentarzy
        */

    }

    @PostMapping(path = "/comment/new")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto comment){

        return commentService.addComment(comment);
    }
}
