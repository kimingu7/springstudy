package com.example.test.service;

import com.example.test.dto.ArticleInformationDto;
import com.example.test.dto.ArticleListDto;
import com.example.test.dto.CreateCommentDto;
import com.example.test.dto.UpdateArticleDto;
import com.example.test.model.Article;
import com.example.test.model.Comment;
import com.example.test.repository.ArticleRepository;
import com.example.test.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public void createArticle(ArticleInformationDto articleInformationDto){
        Article article = articleInformationDto.toArticle();
        articleRepository.save(article);
    }

    public void deleteArticle(Long articleId){
        articleRepository.deleteById(articleId);
    }

    @Transactional
    public void updateArticle(Long articleId, UpdateArticleDto updateArticleDto) {
        Article article = articleRepository.findById(articleId).get();
        article.setTitle(updateArticleDto.getTitle());
        article.setContent(updateArticleDto.getContent());
    }

    public void createComment(Long articleId, CreateCommentDto createCommentDto){
        Article article = articleRepository.findById(articleId).get();
        Comment comment = createCommentDto.toComment();
        commentRepository.save(comment);
    }

    public ArticleListDto getAllArticles(){
        List<Article> articleList = articleRepository.findAll();
        List<ArticleInformationDto> list = new ArrayList<>();

        for (Article article : articleList){
            ArticleInformationDto dto = new ArticleInformationDto(article);
            list.add(dto);
        }

        ArticleListDto response = new ArticleListDto(list);
        return response;
    }

    public ArticleInformationDto getArticleById(Long articleId){
        Article article = articleRepository.findById(articleId).get();
        ArticleInformationDto response = new ArticleInformationDto(article);
        return response;
    }

}
