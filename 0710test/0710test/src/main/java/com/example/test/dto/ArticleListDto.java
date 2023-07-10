package com.example.test.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ArticleListDto {
    private List<ArticleInformationDto> articleList;
    private int code;
    private String message;


    public ArticleListDto(List<ArticleInformationDto> list){
        this.articleList = list;
    }
}
