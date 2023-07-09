package com.example.test.dto;

import lombok.Data;

@Data
public class ArticleListCheckDto {
    private int code;
    private Object data;
    private String message;

    public ArticleListCheckDto(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
