package com.groupa15.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.groupa15.common.dto.ArticlePageDto;
import com.groupa15.entity.Article;
import com.groupa15.entity.vo.ArticleScreenshotVO;
import com.groupa15.entity.vo.ArticleTypeVO;
import com.groupa15.entity.vo.TagTypeVO;

import java.util.List;

/**
 * @author Qi Xu
 * @date 2022/4/5
 */

public interface ArticleService extends IService<Article> {

    Article getArticleById(Long id);

    Article getArticleByTitle(String title);

    List<ArticleScreenshotVO> getArticlePage(ArticlePageDto articlePageDto, Long viewerId);

    List<ArticleScreenshotVO> getArticlePageOfUserId(ArticlePageDto articlePageDto, Long userId);

    List<ArticleScreenshotVO> getArticlePageOfFavourite(ArticlePageDto articlePageDto, Long viewerId);

    List<ArticleScreenshotVO> getArticlePageOfHistory(ArticlePageDto articlePageDto, Long viewerId);

    List<ArticleScreenshotVO> getArticlePageOfKeyWord(ArticlePageDto articlePageDto, Long viewerId, String keyWord);

    List<ArticleScreenshotVO> getArticlePageOfType(ArticlePageDto articlePageDto, Long viewerId, Long typeId);

    Boolean changeFavouriteArticle(Long userId, Long articleId);

    Boolean addHistoryArticle(Long userId, Long articleId);

    Boolean removeHistoryArticle(Long userId, Long articleId);

    List<TagTypeVO> getAllTags();

    List<ArticleTypeVO> getAllArticleTypes();

    void addArticle(Article article);

}
