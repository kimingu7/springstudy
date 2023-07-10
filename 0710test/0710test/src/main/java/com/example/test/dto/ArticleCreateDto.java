package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ArticleCreateDto {
    private String title;
    private String content;

    public Article toArticle(){ // Article의 toArticle 메서드는 생성자 new를 통해 this.title, this,content를 가지는 Article을 반환한다.
        return new Article(this.title, this.content);
    }
    public ArticleCreateDto(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
