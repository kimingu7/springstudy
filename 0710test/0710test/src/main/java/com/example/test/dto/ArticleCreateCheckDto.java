package com.example.test.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ArticleCreateCheckDto {
    private int code;
    private Object data;
    private String message;

    public ArticleCreateCheckDto(int code, Object data, String message){
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
