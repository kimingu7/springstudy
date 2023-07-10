package com.example.test.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCommentCheckDto {
    private int code;
    private Object data;
    private String message;

    public CreateCommentCheckDto(int code, Object data, String message){
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
