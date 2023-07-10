package com.example.test.dto;

import lombok.Data;

@Data
public class ArticleByIdDto {
    private int code;
    private ArticleInformationDto data;
    private String message;

    public ArticleByIdDto(int code, ArticleInformationDto data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
