package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // 이건 모든 생성자를 허용함
public class Response <T>{ // Response를 요구할 때 일일이 Dto를 다 만드는 것이 아니라, 하나의 Response를 만들어 재사용함
    private int code;
    private T data;
    private String message;
}