package com.example.test.service;

import com.example.test.dto.*;
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

    public void createArticle(ArticleCreateDto articleCreateDto){
        Article article = articleCreateDto.toArticle();
        articleRepository.save(article);
    }

    public void deleteArticle(Long articleId){
        articleRepository.deleteById(articleId);
    }

    @Transactional
    public void updateArticle(Long articleId, ArticleUpdateDto articleUpdateDto){
        Article article = articleRepository.findById(articleId).get();
        article.setTitle(articleUpdateDto.getTitle());
        article.setContent(articleUpdateDto.getContent());
    }

    public void createComment(Long articleId, CommentCreateDto commentCreateDto){
        Article article = articleRepository.findById(articleId).get();
        Comment comment = commentCreateDto.toComment(article);
        commentRepository.save(comment);
    }

    public ArticleListDto getAllArticles(){
        List<Article> articleList =articleRepository.findAll();
        List<ArticleInformationDto> list = new ArrayList<>();

        for (Article article : articleList){
            ArticleInformationDto dto = new ArticleInformationDto(article);
            list.add(dto);
        }

        ArticleListDto response = new ArticleListDto(list);
        return response;
    }

    public ArticleFindByIdDto getArticleById(Long articleId){
        Article article =articleRepository.findById(articleId).get();
        List<Comment> commentList =commentRepository.findAllByArticleId(article.getId());
        List<CommentInformationDto> list = new ArrayList<>();

        for ( Comment comment : commentList){
            CommentInformationDto dto = new CommentInformationDto(comment);
            list.add(dto);
        }

        ArticleFindByIdDto response = new ArticleFindByIdDto(article, list);

        return response;
    }

}