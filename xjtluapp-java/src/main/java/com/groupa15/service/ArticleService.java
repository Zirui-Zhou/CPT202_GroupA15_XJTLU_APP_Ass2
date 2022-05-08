package com.groupa15.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.groupa15.entity.dto.ArticlePageDto;
import com.groupa15.entity.Article;
import com.groupa15.entity.dto.EditArticleDto;
import com.groupa15.entity.vo.ArticleScreenshotVO;
import com.groupa15.entity.vo.ArticleTypeVO;

import java.util.List;

/**
 * @author Qi Xu
 * @date 2022/4/5
 */

public interface ArticleService extends IService<Article> {

    Article getArticleById(Long id);

    List<ArticleScreenshotVO> getArticlePage(ArticlePageDto articlePageDto, Long viewerId);

    List<ArticleScreenshotVO> getArticlePageOfUserId(ArticlePageDto articlePageDto, Long userId);

    List<ArticleScreenshotVO> getArticlePageOfFavourite(ArticlePageDto articlePageDto, Long viewerId);

    List<ArticleScreenshotVO> getArticlePageOfHistory(ArticlePageDto articlePageDto, Long viewerId);

    List<ArticleScreenshotVO> getArticlePageOfKeyWord(ArticlePageDto articlePageDto, Long viewerId, String keyWord);

    List<ArticleScreenshotVO> getArticlePageOfType(ArticlePageDto articlePageDto, Long viewerId, Long typeId);

    Boolean changeFavouriteArticle(Long userId, Long articleId);

    Boolean addHistoryArticle(Long userId, Long articleId);

    Boolean removeHistoryArticle(Long userId, Long articleId);

    List<ArticleTypeVO> getAllArticleTypes(String lang);

    Long addArticle(Long userId, EditArticleDto articleDto);

    Boolean editArticle(Long userId, EditArticleDto articleDto);

    Boolean removeArticle(Long userId, Long articleId);

}
