package com.example.test.dto;

import com.example.test.model.Article;
import com.example.test.model.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCommentDto {
    private String content;

    public Comment toComment(Article article){ // Comment 타입의 Article 타입의 article을 매개변수로 가지는 toComment 생성자
        return new Comment(this.content, article); // Comment는 this.conten와 article을 매개변수로 가진다.
    }

    public CreateCommentDto(Comment comment) { // CreateCommentDto는 Comment 타입의 comment를 매개변수로 가짐
        this.content = comment.getContent(); // 이 때 CreateCommentDto의 content는 comment에서 getContent()를 할당
    }
}