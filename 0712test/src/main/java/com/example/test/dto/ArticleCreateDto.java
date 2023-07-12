package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArticleCreateDto {
    @Data
    @NoArgsConstructor
    public static class Request{ // 하위 클래스이기 때문에 static을 붙여준다. 프론트단에서 요청보낸 데이터를 받기 때문에 Request
        private String title;
        private String content;

        public Article toArticle(){
            return new Article(this.title, this.content);
        }

        public Request(Article article){
            this.title = article.getTitle();
            this.content = article.getContent();
        }
    }
}
