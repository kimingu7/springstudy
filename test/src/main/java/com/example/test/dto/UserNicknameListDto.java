package com.example.test.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserNicknameListDto {
    List<UserNicknameDto> userNicknameDtoList;

    public UserNicknameListDto(List<UserNicknameDto> list){
        this.userNicknameDtoList = list;
    }
}