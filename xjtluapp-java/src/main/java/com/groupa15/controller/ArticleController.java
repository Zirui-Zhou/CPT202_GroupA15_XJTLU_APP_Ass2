package com.groupa15.controller;

import com.groupa15.common.dto.ArticleListDto;
import com.groupa15.common.dto.LoginDto;
import com.groupa15.common.lang.Response;
import com.groupa15.entity.Article;
import com.groupa15.entity.User;
import com.groupa15.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
    public Response getArticle(@RequestParam(name = "id") int id, HttpServletResponse httpServletRequest) {
        Article article = articleService.getArticleByArticleId(id);
        return Response.success(HttpStatus.OK, null, article);
    }

    @PostMapping("/article/add")
    public Response addArticle(@RequestBody Article article, HttpServletRequest httpServletRequest) {
        articleService.addArticle(article);
        return Response.success(HttpStatus.OK, article.getArticleTitle());
    }

    @PostMapping("/articlelist")
    public Response getArticleList(@RequestBody ArticleListDto articleListDto, HttpServletRequest httpServletRequest) {
        List<Article> articleList = articleService.getArticleListById(articleListDto);
        return Response.success(HttpStatus.OK, "Get the article list", articleList);
    }

}
