package com.example.test.service;

import com.example.test.dto.SignInDto;
import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void create(SignInDto signInDto){
        User user = signInDto.toUser();
        userRepository.save(user);
    }

    // 1번
    public void getUserById(Long id){
        userRepository.findById(id);
    }

    //2번
    public void getAllUsers(){
        userRepository.findAll();
    }

    //3번
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    //4번
    public void updateUser(Long userId, SignInDto signInDto) {
        User user = userRepository.findById(userId).orElse(null);
            user.setName(signInDto.getName());
            user.setNickname(signInDto.getNickname());
            user.setType(signInDto.getType());
            userRepository.save(user);
    }
}
