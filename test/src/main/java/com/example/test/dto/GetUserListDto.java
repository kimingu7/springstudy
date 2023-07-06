package com.example.test.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetUserListDto {
    private List<SignInResponseDto> userList; // SignInResponseDto를 참조한 List인 userList를 생성

    public GetUserListDto(List<SignInResponseDto> list){ // list는 GetUserListDto 내부에서 사용할 list
        this.userList = list;
    }
}
