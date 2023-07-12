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

    public void createArticle(ArticleCreateDto.Request request){ // ArticleCreateDto의 하위클래스에서 가져와야하기 때문에 ArticleCreateDto.Request로 변경해준다
        Article article = request.toArticle();
        articleRepository.save(article);
    }

    public void deleteArticle(Long articleId){
        articleRepository.deleteById(articleId);
    }

    @Transactional
    public void updateArticle(Long articleId, ArticleUpdateDto.Request request){
        Article article = articleRepository.findById(articleId).get();
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
    }

    public void createComment(Long articleId, CommentCreateDto.Request request){
        Article article = articleRepository.findById(articleId).get();
        Comment comment = request.toComment(article);
        commentRepository.save(comment);
    }

    public ArticleListDto.Response getAllAriticles(){ // 마찬가지로 ArticleListDto의 하위클래스 Resonse에서 가져오는 것이기 때문에 ArticleResponse.Response로 변경해줘야한다.
        List<Article> articleList = articleRepository.findAll();
        List<ArticleInformationDto> list = new ArrayList<>();

        for ( Article article : articleList ){
            ArticleInformationDto dto = new ArticleInformationDto(article);
            list.add(dto);
        }
        ArticleListDto.Response response = new ArticleListDto.Response(list);
        return response;
    }

    public ArticleFindByIdDto.Response getArticleById(Long articleId){
        Article article =articleRepository.findById(articleId).get();
        List<Comment> commentList =commentRepository.findALlByArticleId(article.getId());
        List<CommentInformationDto> list = new ArrayList<>();

        for ( Comment comment : commentList){
            CommentInformationDto dto = new CommentInformationDto(comment);
            list.add(dto);
        }

        ArticleFindByIdDto.Response response = new ArticleFindByIdDto.Response(article, list);

        return response;
    }

}
