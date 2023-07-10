package com.example.test.repository;

import com.example.test.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>  {
    List<Comment> findAllByArticleId(Long articleId); // findAllByArticleId 메서드는 Long 타입의 articleId를 매개변수로 가지며, 해당 매개변수와 일치하는 Comment 타입의 List를 반환한다.
}
