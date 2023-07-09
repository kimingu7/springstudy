package com.example.test.dto;

public class ArticleByIdDto {
    private int code;
    private Object data;
    private String message;

    public ArticleByIdDto(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
