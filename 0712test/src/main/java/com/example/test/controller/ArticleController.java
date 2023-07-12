package com.example.test.controller;

import com.example.test.dto.*;
import com.example.test.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/article/create")
    public Response<?> createArticle(@RequestBody ArticleCreateDto.Request request){ // Response의 Generic 안에는 타입이 정해지지 않았기 때문에 ?를 넣어도 된다. ArticleCreateDto의 하위 클래스 Request는 ArticleCreateDto.Request로 나타낸다.
        articleService.createArticle(request);
        int code = 200;
        String message = "정상적으로 글을 작성했습니다.";

        return new Response<>(code, null, message); // code와 message를 넣어주고, data는 null값이 들어가기에 바로 넣어준다.
    }

    @DeleteMapping("/article/delete/{articleId}")
    public Response<?> deleteArticle(@PathVariable Long articleId){
        articleService.deleteArticle(articleId);
        int code = 200;
        String message = "정상적으로 글을 삭제했습니다.";

        return new Response<>(code, null, message);
    }

    @PutMapping("/article/update/{articleId}")
    public Response<?> updateArticle(@PathVariable Long articleId, @RequestBody ArticleUpdateDto.Request request){
        articleService.updateArticle(articleId, request);
        int code = 201;
        String message = "정상적으로 글을 수정했습니다.";

        return new Response<>(code, null, message);
    }

    @PostMapping("/article/{articleId}/comment")
    public Response<?> createComment(@PathVariable Long articleId, @RequestBody CommentCreateDto.Request request){
        articleService.createComment(articleId, request);
        int code = 200;
        String message = "정상적으로 댓글을 작성했습니다.";

        return new Response<>(code, null, message);
    }

    @GetMapping("/articles")
    public Response<ArticleListDto.Response> getAllArticles(){ // 위와 달리 ArticleListDto에 정의된 하위 클래스 ArticleListDto.Response를 타입으로 가진다.
        int code = 200;
        ArticleListDto.Response data = articleService.getAllAriticles();
        String message = "정상적으로 모든 게시글을 가져왔습니다";

        return new Response<ArticleListDto.Response>(code, data, message); // 위와 달리 data는 ArticleListDto.Response 타입으로, articleService.getAllArticles()를 통해 가져온다.
    }

    @GetMapping("/article/read/{articleId}")
    public Response<ArticleFindByIdDto.Response> getArticleById(@PathVariable Long articleId){
        int code = 200;
        ArticleFindByIdDto.Response data = articleService.getArticleById(articleId);
        String message = "정상적으로 해당 게시글을 가져왔습니다.";

        return new Response<ArticleFindByIdDto.Response>(code, data, message);
    }
}
