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
    public ArticleCreateCheckDto createArticle(@RequestBody ArticleCreateDto articleCreateDto){
        articleService.createArticle(articleCreateDto);
        int code = 200;
        Object data = null;
        String message = "정상적으로 게시글이 작성되었습니다.";

        return new ArticleCreateCheckDto(code, data, message);
    }

    @DeleteMapping("/article/delete/{articleId}")
    public ArticleDeleteDto deleteArticle(@PathVariable Long articleId){
        articleService.deleteArticle(articleId);
        int code = 200;
        Object data = null;
        String message = "정상적으로 게시글이 삭제되었습니다.";

        return new ArticleDeleteDto(code, data, message);
    }

    @PutMapping("/article/update/{articleId}")
    public ArticleUpdateCheckDto updateArticle(@PathVariable Long articleId, @RequestBody ArticleUpdateDto articleUpdateDto){
        articleService.updateArticle(articleId, articleUpdateDto);
        int code = 200;
        Object data = null;
        String message = "정상적으로 게시글이 수정되었습니다.";

        return new ArticleUpdateCheckDto(code, data, message);
    }

    @PostMapping("/article/{articleId}/comment")
    public CommentCreateCheckDto createComment(@PathVariable Long articleId, @RequestBody CommentCreateDto commentCreateDto){
        articleService.createComment(articleId, commentCreateDto);
        int code = 200;
        Object data = null;
        String message = "정상적으로 댓글이 작성되었습니다.";

        return new CommentCreateCheckDto(code, data, message);
    }

    @GetMapping("/articles")
    public ArticleListDto getAllArticles(){
        int code = 200;
        ArticleListDto data = articleService.getAllArticles();
        String message = "정상적으로 모든 게시글을 가져왔습니다.";

        data.setCode(code);
        data.setMessage(message);

        return data;
    }

    @GetMapping("/article/read/{articleId}")
    public ArticleFindByIdDto getArticleById(@PathVariable Long articleId){
        int code = 200;
        ArticleFindByIdDto data = articleService.getArticleById(articleId);
        String message = "정상적으로 해당 게시글을 가져왔습니다.";

        data.setCode(code);
        data.setMessage(message);

        return data;
    }
}
