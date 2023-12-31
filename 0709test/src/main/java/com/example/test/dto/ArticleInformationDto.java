package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ArticleInformationDto {
    private String title;
    private String content;
    private List<CreateCommentDto> list;

    public Article toArticle(){
        return new Article(this.title, this.content);
    }
    public ArticleInformationDto(Article article, List<CreateCommentDto> list){
        this.title = article.getTitle();
        this.content = article.getContent();
        this.list = list;
    };
}
