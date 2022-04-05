package com.groupa15.service.impl;

import com.groupa15.common.dto.ArticleListDto;
import com.groupa15.entity.Article;
import com.groupa15.repo.ArticleRepo;
import com.groupa15.service.ArticleService;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Zirui Zhou
 * @date 2022/4/5
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepo articleRepo;

    @Override
    public Article getArticleByArticleId(int articleId) {
        Optional<Article> article = articleRepo.findById(articleId);
        if(article.isEmpty()) {
            throw new UnknownAccountException("The article does not exist.");
        }
        return article.get();
    }

    @Override
    public List<Article> getArticleListById(ArticleListDto articleListDto) {
        int from = articleListDto.getFromIndex();
        int to = from + articleListDto.getArticleNum();
        return articleRepo.findByArticleIdBetween(from, to);
    }

    @Override
    public Article getArticleByArticleTitle(String articleTitle) {
        return null;
    }

    @Override
    public void addArticle(Article article) {
        article.setArticleId(null);
        articleRepo.save(article);
    }
}
