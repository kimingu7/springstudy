package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArticleInformationDto {
    private String title;
    private String content;

    public ArticleInformationDto(Article article) { // ArticleInformationDto는 Article 타입의 article을 매개변수로 가진다.
        this.title = article.getTitle(); // ArticleInformationDto의 title은 article에서 getTitle()로 가져온 값을 할당한다.
        this.content = article.getContent();
    }
}
