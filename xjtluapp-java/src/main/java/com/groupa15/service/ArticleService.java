package com.groupa15.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.groupa15.common.dto.ArticlePageDto;
import com.groupa15.entity.Article;
import com.groupa15.entity.vo.ArticleScreenshotVO;
import com.groupa15.entity.vo.TagTypeVO;

import java.util.List;

/**
 * @author Qi Xu
 * @date 2022/4/5
 */

public interface ArticleService extends IService<Article> {

    Article getArticleById(Long id);

    Article getArticleByTitle(String title);

    List<ArticleScreenshotVO> getArticlePage(ArticlePageDto articlePageDto);

    List<ArticleScreenshotVO> getArticlePageOfUserId(ArticlePageDto articlePageDto, Long userId);

    List<TagTypeVO> getAllTags();

    void addArticle(Article article);

}
