package com.groupa15.controller;

import com.groupa15.common.dto.ArticlePageDto;
import com.groupa15.common.lang.Response;
import com.groupa15.entity.Article;
import com.groupa15.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/5
 */

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping(value = "/article")
    public Response getArticle(@RequestParam(name = "id") Long id, HttpServletResponse httpServletRequest) {
        Article article = articleService.getArticleById(id);
        return Response.success(HttpStatus.OK, null, article);
    }

    @PostMapping("/article/add")
    public Response addArticle(@RequestBody Article article, HttpServletRequest httpServletRequest) {
        articleService.addArticle(article);
        return Response.success(HttpStatus.OK, article.getTitle());
    }

    @PostMapping("/article/list")
    public Response getArticleList(@RequestBody ArticlePageDto articleListDto, HttpServletRequest httpServletRequest) {
        List<Article> articleList = articleService.getArticlePageById(articleListDto);
        return Response.success(HttpStatus.OK, "Get the article list", articleList);
    }

}
