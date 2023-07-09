package com.example.test.dto;

import com.example.test.model.User;
import lombok.Data;

@Data
public class UserInformationDto {
    private String name;
    private String nickname;
    private String type;

    public UserInformationDto(User user) { // Customizing된 생성자를 사용하면 기본 생성자는 사라지기 때문에 오류가 발생하면 기본 생성자를 다시 정의해야함
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.type = user.getType();
    }
}
