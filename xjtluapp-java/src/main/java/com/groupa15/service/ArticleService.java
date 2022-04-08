package com.groupa15.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.groupa15.common.dto.ArticlePageDto;
import com.groupa15.entity.Article;

import java.util.List;

/**
 * @author Qi Xu
 * @date 2022/4/5
 */

public interface ArticleService extends IService<Article> {
    Article getArticleById(Long id);
    Article getArticleByTitle(String title);
    List<Article> getArticlePageById(ArticlePageDto articleListDto);
    void addArticle(Article article);
}
