package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArticleUpdateDto {
    private String title;
    private String content;

    public ArticleUpdateDto(Article article) { // ArticleUpdateDto는 Article 타입의 article을 매개변수로 가짐
        this.title = article.getTitle(); // 이 인스턴스의 title 속성은 article.getTitle()을 통해 얻은 데이터를 할당함
        this.content = article.getContent();
    }
}
