package com.example.test.repository;

import com.example.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByName(String name);
    List<User> findAllByNickname(String nickname);
}
