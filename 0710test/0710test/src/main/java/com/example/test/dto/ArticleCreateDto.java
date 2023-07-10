package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ArticleCreateDto {
    private String title;
    private String content;

    public Article toArticle(){
        return new Article(this.title, this.content);
    }
    public ArticleCreateDto(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
