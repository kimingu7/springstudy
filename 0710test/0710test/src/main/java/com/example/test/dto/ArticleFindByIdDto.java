package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ArticleFindByIdDto { // Dto 안에 code와 message를 포함할 수 있다.
    private String title;
    private String content;
    private List<CreateCommentDto> comments; // List는 CreateCommentDto를 원소로 가진다
    private int code;
    private String message;

    public ArticleFindByIdDto(Article article, List<CreateCommentDto> comments){ // ArticleFindByIdDto의 매개변수는 article과 comments이다.
        this.title = article.getTitle(); // title은 article에서 getTitle로 가져온다
        this.content = article.getContent();
        this.comments = comments; // comments는 comments로 가져오면 된다.
    }
}
