package com.example.test.repository;

import com.example.test.dto.CommentInformationDto;
import com.example.test.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findALlByArticleId(Long id);
}
