package com.example.test.dto;

import com.example.test.model.Comment;
import lombok.Data;

@Data
public class CreateCommentDto {

    private String content;

    public Comment toComment(){
        return new Comment(this.content);
    }
}
