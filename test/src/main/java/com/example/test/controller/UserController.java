package com.example.test.controller;

import com.example.test.dto.*;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup(@RequestBody SignInDto signInDto){
        userService.create(signInDto);
        return "";
    }

    // 1번
    @GetMapping("/user/{userId}")
    public SignInResponseDto getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    // 2번
    @GetMapping("/users")
    public GetUserListDto getAllUsers(){
        return userService.getAllUsers();
    }

    // 3번
    @DeleteMapping("/user/{userId}")
    public DeleteUserDto deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new DeleteUserDto(true);
    }

    // 4번
    @PutMapping("/user/{userId}")
    public UserUpdateCheckDto updateUser(@PathVariable Long userId, @RequestBody UserUpdateDto updateDto){
        userService.updateUser(userId, updateDto);
        return new UserUpdateCheckDto(true);
    }
}
