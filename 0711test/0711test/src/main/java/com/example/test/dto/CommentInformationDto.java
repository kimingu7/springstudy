package com.example.test.dto;

import com.example.test.model.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentInformationDto {
    private String content;

    public CommentInformationDto(Comment comment){
        this.content = comment.getContent();
    }
}
