package com.example.test.dto;

import lombok.Data;

@Data
public class UserUpdateCheckDto {
    private boolean success;

    public UserUpdateCheckDto(boolean success){
        this.success = success;
    }
}