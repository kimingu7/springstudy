package com.example.test.dto;

import com.example.test.model.Article;
import com.example.test.model.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCommentDto {
    private String content;

    public Comment toComment(Article article){
        return new Comment(this.content, article);
    }


    public CreateCommentDto(Comment comment) {
        this.content = comment.getContent();
    }
}
