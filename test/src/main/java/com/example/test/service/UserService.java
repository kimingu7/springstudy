package com.example.test.service;

import com.example.test.dto.*;
import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void create(SignInDto signInDto){
        User user = signInDto.toUser();
        userRepository.save(user);
    }

    // 1번
    public SignInResponseDto getUserById(Long id){ // User Model의 user 객체는 userRepository에서 findById로 찾은 하나의 객체, get()를 붙여야함
       User user = userRepository.findById(id).get(); //
       SignInResponseDto response = new SignInResponseDto(user); // 이 때 SigninResponseDto response는 user에 해당하는 this.name, this.nickname, this.type을 가지고 있는 객체
       return response; // 그래서 response를 return하게 되면 this.name, this.nickname, this.type으로 이뤄진 객체를 return 하게 되는 것
    }

    public UserListDto getUserByName(String name){
        List<User> userList = userRepository.findAllByName(name);
        List<UserInformationDto> list = new ArrayList<>();
        for (User user : userList){
            UserInformationDto dto = new UserInformationDto(user);
            list.add(dto);
        };
        UserListDto response = new UserListDto(list);
        return response;
    }

    //2번
    public GetUserListDto getAllUsers(){
        List<User> userList = userRepository.findAll(); // userList는 User 타입을 가지는 list
        List<SignInResponseDto> list = new ArrayList<>(); // list는 SignInResponseDto 타입을 가지는 ArrayList

        for (User user : userList){ // userList 안의 user들을 순회하면서
            SignInResponseDto dto = new SignInResponseDto(user); // dto는 SignInResponseDto의 user에 해당하는 name, nickname, type으로 이뤄진 객체
            list.add(dto); // list에 dto를 추가
        }

        GetUserListDto response = new GetUserListDto(list); // response는 위에서 만들어진 list
        return response; // 그래서 response에서는 dto 객체들로 이뤄진 list를 반환함
    }

    //3번
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    //4번
    @Transactional
    public void updateUser(Long userId, UserUpdateDto updateDto) { // update를 할 때는 getter와 setter를 통해서 user의 data를 변경해준다
        User user = userRepository.findById(userId).get(); // User model의 user는 userId로 findById를 통해 get된 객체
        user.setName(updateDto.getName()); // UserUpdateDto의 updateDto에서 getName을 통해 얻은
        user.setNickname(updateDto.getNickname());
        user.setType(updateDto.getType());
    }

    public UserNicknameListDto getUserByNickname(String nickname){
        List<User> userList = userRepository.findAllByNickname(nickname);
        List<UserNicknameDto> list = new ArrayList<>();
        for (User user : userList){
            UserNicknameDto dto = new UserNicknameDto(user);
            list.add(dto);
        }
        UserNicknameListDto response = new UserNicknameListDto(list);
        return response;
    }
}
