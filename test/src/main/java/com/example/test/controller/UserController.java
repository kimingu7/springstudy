package com.example.test.controller;

import com.example.test.dto.SignInDto;
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
    public String getUserById(@PathVariable Long userId){
        userService.getUserById(userId);
        return "";
    }

    // 2번
    @GetMapping("/users")
    public String getAllUsers(){
        userService.getAllUsers();
        return "";
    }

    // 3번
    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return "success";
    }

    // 4번
    @PutMapping("/user/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody SignInDto updatedDto){
        userService.updateUser(userId, updatedDto);
        return "success";
    }
}
