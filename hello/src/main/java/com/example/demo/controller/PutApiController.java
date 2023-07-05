package com.example.demo.controller;


import com.example.demo.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api3")
public class PutApiController {

    @PutMapping("/put")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto){
        System.out.println(requestDto);
        return requestDto;
    }
}
