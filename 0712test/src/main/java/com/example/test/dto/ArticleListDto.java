package com.example.test.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ArticleListDto {

    @Data
    @NoArgsConstructor
    public static class Response{
        private List<ArticleInformationDto> articleList;

        public Response(List<ArticleInformationDto> list){
            this.articleList = list;
        }
    }

}
