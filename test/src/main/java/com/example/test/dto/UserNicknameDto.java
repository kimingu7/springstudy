package com.example.test.dto;

import com.example.test.model.User;
import lombok.Data;

@Data
public class UserNicknameDto {
    private String name;
    private String nickname;
    private String type;

    public UserNicknameDto(User user){
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.type = user.getType();
    }
}
