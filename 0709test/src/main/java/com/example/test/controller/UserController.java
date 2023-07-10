package com.example.test.controller;

import com.example.test.dto.*;
import com.example.test.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final ArticleService articleService;

    @PostMapping("/article/create")
    public CreateArticleDto createArticle(@RequestBody ArticleInformationDto articleInformationDto){
        articleService.createArticle(articleInformationDto);
        int code = 200;
        Object data = null;
        String message = "정상적으로 등록되었습니다.";

        return new CreateArticleDto(code, data, message);
    }

    @DeleteMapping("/article/delete/{articleId}")
    public DeleteArticleDto deleteArticle(@PathVariable Long articleId){
        articleService.deleteArticle(articleId);
        int code = 200;
        Object data = null;
        String message = "정상적으로 삭제되었습니다.";
        return new DeleteArticleDto(code, data, message);
    }

    @PutMapping("/article/update/{articleId}")
    public UpdateArticleCheckDto updateArticle(@PathVariable Long articleId, @RequestBody UpdateArticleDto updateArticleDto){
        articleService.updateArticle(articleId, updateArticleDto);

        int code = 200;
        Object data = null;
        String message = "정상적으로 수정되었습니다.";
        return new UpdateArticleCheckDto(code, data, message);
    }

    @PostMapping("/article/{articleId}/comment")
    public CreateCommentCheckDto createComment(@PathVariable Long articleId, @RequestBody CreateCommentDto createcommentDto){
        articleService.createComment(articleId, createcommentDto);

        int code = 200;
        Object data = null;
        String message = "정상적으로 댓글을 생성했습니다.";
        return new CreateCommentCheckDto(code, data, message);
    }

    @GetMapping("/article")
    public ArticleListCheckDto getAllArticles(){
        int code = 200;
        ArticleListDto data = articleService.getAllArticles();
        String message = "정상적으로 모든 게시글을 가져왔습니다.";

        return new ArticleListCheckDto(code, data, message);
    }

    @GetMapping("/article/read/{articleId}")
    public ArticleByIdDto getArticleById(@PathVariable Long articleId){
        int code = 200;
        ArticleInformationDto data = articleService.getArticleById(articleId);
        String message = "정상적으로 해당 게시글을 가져왔습니다.";
        return new ArticleByIdDto(code, data, message);
    }

}
