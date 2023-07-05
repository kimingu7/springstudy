package com.example.test.dto;

import com.example.test.model.User;
import lombok.Data;

@Data
public class SignInDto {
    private String name;
    private String nickname;
    private String password;
    private String type;

    public User toUser(){
        return new User(this.name, this.nickname, this.password, this.type);
    }
}
