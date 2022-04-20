package com.groupa15.controller;

import com.groupa15.common.dto.ArticlePageDto;
import com.groupa15.common.Response;
import com.groupa15.entity.Article;
import com.groupa15.entity.vo.ArticleScreenshotVO;
import com.groupa15.entity.vo.ArticleTypeVO;
import com.groupa15.entity.vo.ResourceTagVO;
import com.groupa15.service.ArticleService;
import com.groupa15.utils.JwtUtils;
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

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping(value = "/article")
    public Response getArticle(@RequestParam(name = "id") Long id, HttpServletResponse httpServletRequest) {
        Article article = articleService.getArticleById(id);
        return Response.success(HttpStatus.OK, null, article);
    }

    @GetMapping("/article/types")
    public Response getArticleTypes(@RequestHeader(value = "Accept-Language", defaultValue = "en") String lang, HttpServletResponse httpServletRequest) {
        List<ArticleTypeVO> tags = articleService.getAllArticleTypes(lang);
        return Response.success(HttpStatus.OK, null, tags);
    }

    @PostMapping("/article/add")
    public Response addArticle(@RequestBody Article article, HttpServletRequest httpServletRequest) {
        articleService.addArticle(article);
        return Response.success(HttpStatus.OK, article.getTitle());
    }

    @PostMapping("/article/list")
    public Response getArticleList(@RequestHeader(value = "Authorization") String token, @RequestBody ArticlePageDto articleListDto) {
        List<ArticleScreenshotVO> articleList = articleService.getArticlePage(articleListDto, jwtUtils.getUserIdByToken(token));
        return Response.success(HttpStatus.OK, "Get the article list", articleList);
    }

    @PostMapping("/article/list/type")
    public Response getArticleList(@RequestHeader(value = "Authorization") String token, @RequestBody ArticlePageDto articleListDto, @RequestParam(name = "id") Long id) {
        List<ArticleScreenshotVO> articleList = articleService.getArticlePageOfType(articleListDto, jwtUtils.getUserIdByToken(token), id);
        return Response.success(HttpStatus.OK, "Get the article list", articleList);
    }

    @PostMapping("article/list/mine")
    public Response getArticleListOfMine(@RequestHeader(value = "Authorization") String token, @RequestBody ArticlePageDto articleListDto) {
        List<ArticleScreenshotVO> articleList = articleService.getArticlePageOfUserId(articleListDto, jwtUtils.getUserIdByToken(token));
        return Response.success(HttpStatus.OK, "Get the article list", articleList);
    }

    @PostMapping("article/list/favourite")
    public Response getArticleListOfFavourite(@RequestHeader(value = "Authorization") String token, @RequestBody ArticlePageDto articleListDto) {
        List<ArticleScreenshotVO> articleList = articleService.getArticlePageOfFavourite(articleListDto, jwtUtils.getUserIdByToken(token));
        return Response.success(HttpStatus.OK, "Get the article list", articleList);
    }

    @PostMapping("article/list/history")
    public Response getArticleListOfHistory(@RequestHeader(value = "Authorization") String token, @RequestBody ArticlePageDto articleListDto) {
        List<ArticleScreenshotVO> articleList = articleService.getArticlePageOfHistory(articleListDto, jwtUtils.getUserIdByToken(token));
        return Response.success(HttpStatus.OK, "Get the article list", articleList);
    }

    @PostMapping("article/list/search")
    public Response getArticleListOfSearch(@RequestHeader(value = "Authorization") String token, @RequestBody ArticlePageDto articleListDto, @RequestParam(name = "word") String word) {
        List<ArticleScreenshotVO> articleList = articleService.getArticlePageOfKeyWord(articleListDto, jwtUtils.getUserIdByToken(token), word);
        return Response.success(HttpStatus.OK, "Get the article list", articleList);
    }

    @GetMapping("article/favourite")
    public Response handleFavouriteArticle(@RequestHeader(value = "Authorization") String token, @RequestParam(name = "id") Long id) {
        Boolean result = articleService.changeFavouriteArticle(jwtUtils.getUserIdByToken(token), id);
        return Response.success(HttpStatus.OK, null, result);
    }

    @GetMapping("article/history/add")
    public Response addHistoryArticle(@RequestHeader(value = "Authorization") String token, @RequestParam(name = "id") Long id) {
        Boolean result = articleService.addHistoryArticle(jwtUtils.getUserIdByToken(token), id);
        return Response.success(HttpStatus.OK, null, result);
    }

    @GetMapping("article/history/remove")
    public Response removeHistoryArticle(@RequestHeader(value = "Authorization") String token, @RequestParam(name = "id") Long id) {
        Boolean result = articleService.removeHistoryArticle(jwtUtils.getUserIdByToken(token), id);
        return Response.success(HttpStatus.OK, null, result);
    }

}
