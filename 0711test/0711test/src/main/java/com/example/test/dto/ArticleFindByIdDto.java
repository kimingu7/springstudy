package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ArticleFindByIdDto {

    private String title;
    private String content;
    private List<CommentInformationDto> commentList;
    private int code;
    private String message;

    public ArticleFindByIdDto(Article article, List<CommentInformationDto> commentList){
        this.title = article.getTitle();
        this.content = article.getContent();
        this.commentList = commentList;
    }

}