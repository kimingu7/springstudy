package com.example.test.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue의 Column 이름이 다른 Table과 같을 때 strategy = GenerationType.IDENTITY를 통해 구분할 수 있다.
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }
}
