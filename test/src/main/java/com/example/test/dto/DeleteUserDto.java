package com.example.test.dto;

import lombok.Data;

@Data
public class DeleteUserDto {
    private boolean success;

    public DeleteUserDto(boolean success){
        this.success = success;
    }
}
