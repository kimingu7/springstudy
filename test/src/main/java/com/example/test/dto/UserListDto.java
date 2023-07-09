package com.example.test.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserListDto {
    private List<UserInformationDto> userList;

    public UserListDto(List<UserInformationDto> userList) {
        this.userList = userList;
    }
}
