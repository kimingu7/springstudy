package com.example.test.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentCreateCheckDto {
    private int code;
    private Object data;
    private String message;

    public CommentCreateCheckDto(int code, Object data, String message){
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
