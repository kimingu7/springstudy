package com.example.test.dto;

import com.example.test.model.User;
import lombok.Data;

import java.util.List;

@Data
public class SignInResponseDto {
    private String name;
    private String nickname;
    private String type;

    public SignInResponseDto(User user){ // User는 Model 안의 User, user는 public 안에서 사용할 객체 이름
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.type = user.getType();
    }

}
