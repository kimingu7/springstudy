package com.example.test.dto;

import com.example.test.model.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ArticleFindByIdDto {

    @Data
    @NoArgsConstructor
    public static class Response{ // 하위 클래스는 static으로 만든다. 프론트단에 응답하기 위한 클래스이기 때문에 이름을 Response로 준다
        private String title;
        private String content;
        private List<CommentInformationDto> comments;

        public Response(Article article, List<CommentInformationDto> comments){ // 생성자 이름도 일치시켜준다.
            this.title = article.getTitle();
            this.content = article.getContent();
            this.comments = comments;
        }
    }
}
