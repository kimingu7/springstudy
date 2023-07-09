package com.example.test.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticleListDto {
    private List<ArticleInformationDto> articleList;

    public ArticleListDto(List<ArticleInformationDto> list){
        this.articleList = list;
    }
}
