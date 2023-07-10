package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArticleInformationDto {
    private String title;
    private String content;

    public ArticleInformationDto(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
