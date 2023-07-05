package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST API 처리하는 Controller
@RequestMapping("/api") // RequestMapping URI를 지정
public class ApiController {

    @GetMapping("/hello") // http://localhost:8080/api/hello로 GET 요청
    public String hello(){
        return "hello spring boot!";
    }
}
