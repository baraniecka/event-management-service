package pl.sda.orange.java2.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.orange.java2.event.entity.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "FROM Comment c WHERE c.event.id = :id")
    List<Comment> findCommentWithEventId(@Param("id") Long id);

}
