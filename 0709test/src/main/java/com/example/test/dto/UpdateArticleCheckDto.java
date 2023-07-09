package com.example.test.dto;

import lombok.Data;

@Data
public class UpdateArticleCheckDto {
    private int code;
    private Object data;
    private String message;

    public UpdateArticleCheckDto(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
