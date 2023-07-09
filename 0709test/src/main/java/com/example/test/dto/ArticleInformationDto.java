package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;

@Data
public class ArticleInformationDto {
    private String title;
    private String content;

    public Article toArticle(){
        return new Article(this.title, this.content);
    }

    public ArticleInformationDto(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
