package com.example.test.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    public Comment(String content, Article article){
        this.content = content;
        this.article = article;
    }
}