package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArticleUpdateDto {

    @Data
    @NoArgsConstructor
    public static class Request{
        private String title;
        private String content;

        public Request(Article article){
            this.title = article.getTitle();
            this.content = article.getContent();
        }
    }
}
