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
    private final ArticleRepository articleRepository; // ArticleRepository를 articleRepository로 가져온다
    private final CommentRepository commentRepository;

    public void createArticle(ArticleCreateDto articleCreateDto){ // ArticleCreateDto 타입의 articleCreateDto를 매개변수로 가짐
        Article article = articleCreateDto.toArticle(); // Article 타입의 article은 articleCreateDto의 toArticle 메서드로 가져온 객체
        articleRepository.save(article); // articleRepository의 save 메서드로 article 객체를 저장
    }

    public void deleteArticle(Long articleId){ // 변수로 Long 타입의 articleId를 가진다
        articleRepository.deleteById(articleId); // articleRepository의 deleteById 메서드로 articleId을 가지는 article을 삭제
    }

    @Transactional // Transcational을 통해 올바르지 않은 데이터가 들어왔을 때 변경되는 것을 방지함
    public void updateArticle(Long articleId, ArticleUpdateDto articleUpdateDto){
        Article article = articleRepository.findById(articleId).get(); // article은 Article 타입의 findById 메서드로 articleId를 가지는 객체
        article.setTitle(articleUpdateDto.getTitle()); // article의 setTitle 메서드는 articleupdateDto에서 getTitle 메서드를 통해 받아온 title을 article의 title로 변경함
        article.setContent(articleUpdateDto.getContent());
    }

    public void createComment(Long articleId, CreateCommentDto createCommentDto){ // createComment는 Long 타입의 articleId와 CreateCommentDto 타입의 createCommentDto를 매개변수로 가짐
        Article article = articleRepository.findById(articleId).get(); // article은 findById(articleId).get()을 통해 할당된 객체
        Comment comment = createCommentDto.toComment(article); // toComment 메서드는 article을 매개변수로 가짐
        commentRepository.save(comment); //  commentReposiotry의 save메서드를 통해 comment를 저장
    }

    public ArticleListDto getArticleList(){ // ArticleListDto에서 response를 가져와야하기 때문에 ArticleListDto 타입임을 명시해준다
        List<Article> articleList = articleRepository.findAll(); // articleList는 List<Article(Article 타입)> 타입으로 articleRepository.findAll()를 통해 원소들을 가지는
        List<ArticleInformationDto> list = new ArrayList<>(); // list는 List<ArticleInformationDto(ArticleInformationDto 타입)> 타입으로 빈 ArrayList다.
        for (Article article : articleList){ // articleList는 Article 타입을 가지는 article들을 원소로 가지는데
            ArticleInformationDto dto = new ArticleInformationDto(article); // ArticleInformationDto 타입의 dto에 ArticleInformationDto(article)를 할당한다.
            list.add(dto); // list에 dto를 추가한다
        }
        ArticleListDto response = new ArticleListDto(list); // ArticleListDto 타입의 response는 ArticleListDto(list)를 반환한다.

        return response;
    }

    public ArticleFindByIdDto getArticle(Long articleId){
        Article article = articleRepository.findById(articleId).get(); // Article 타입의 article 객체는 findById(articleId).get()으로 가져온 객체를 할당한다.
        List<Comment> commentList = commentRepository.findAllByArticleId(article.getId()); // Comment 타입을 가지는 List 타입의 commentList는 commentRepository에서 article.getId()를 매개변수로 가지는 findAllByArticleId라는 메서드에서 리스트로 가져온다.
        List<CreateCommentDto> list = new ArrayList<>(); // CreateCommentDto 타입을 가지는 빈 list를 생성한다.
        for (Comment comment : commentList){
            CreateCommentDto dto = new CreateCommentDto(comment);
            list.add(dto);
        }
        ArticleFindByIdDto response = new ArticleFindByIdDto(article, list); // 매개변수는 Article 정보가 담겨있는 article과 Comment 정보가 담겨있는 list이다.

        return response;
    }

}
