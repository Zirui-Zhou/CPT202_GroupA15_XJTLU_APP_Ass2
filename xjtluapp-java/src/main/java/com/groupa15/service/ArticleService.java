package com.groupa15.service;

import com.groupa15.common.dto.ArticleListDto;
import com.groupa15.entity.Article;

import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/5
 */

public interface ArticleService {
    Article getArticleByArticleId(int articleId);
    Article getArticleByArticleTitle(String articleTitle);
    List<Article> getArticleListById(ArticleListDto articleListDto);
    void addArticle(Article article);
}
