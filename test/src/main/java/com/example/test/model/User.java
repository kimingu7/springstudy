package com.example.test.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column // 생략가능하다
    private String name;

    @Column
    private String nickname;

    @Column
    private String password;

    @Column
    private String type;

    public User(String name, String nickname, String password, String type){
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.type = type;
    }
}
