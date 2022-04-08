package com.groupa15.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupa15.common.dto.ArticlePageDto;
import com.groupa15.entity.Article;
import com.groupa15.mapper.ArticleMapper;
import com.groupa15.service.ArticleService;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qi Xu
 * @date 2022/4/5
 */

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article getArticleById(Long id) {
        Article article = this.getById(id);
        if(null == article) {
            // TODO(Zirui): Attempt to define a custom exception to inform this.
            throw new UnknownAccountException("The article does not exist.");
        }
        return article;
    }

    @Override
    public Article getArticleByTitle(String title) {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getTitle, title);
        Article article = this.getOne(wrapper);

        if(article == null) {
            throw new UnknownAccountException("The account does not exist.");
        }

        return article;
    }

    @Override
    public List<Article> getArticlePageById(ArticlePageDto articlePageDto) {
        Page<Article> page = new Page<>(articlePageDto.getCurrent(), articlePageDto.getSize());
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Article::getId);
        articleMapper.selectPage(page, wrapper);
        return page.getRecords();
    }

    @Override
    public void addArticle(Article article) {
        article.setId(null)
                .setCreateTime(null);
        this.save(article);
    }

}
