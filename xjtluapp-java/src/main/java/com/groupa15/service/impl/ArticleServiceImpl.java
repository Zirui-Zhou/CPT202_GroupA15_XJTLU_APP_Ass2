package com.groupa15.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupa15.common.dto.ArticlePageDto;
import com.groupa15.entity.Article;
import com.groupa15.entity.vo.ArticleScreenshotVO;
import com.groupa15.entity.vo.TagTypeVO;
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
        if(article == null) {
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
    public List<ArticleScreenshotVO> getArticlePage(ArticlePageDto articlePageDto) {
        Page<ArticleScreenshotVO> page = new Page<>(articlePageDto.getCurrent(), articlePageDto.getSize());
        page = articleMapper.getArticlePageVo(page);
        return page.getRecords();
    }

    @Override
    public List<ArticleScreenshotVO> getArticlePageOfUserId(ArticlePageDto articlePageDto, Long userId) {
        Page<ArticleScreenshotVO> page = new Page<>(articlePageDto.getCurrent(), articlePageDto.getSize());
        page = articleMapper.getArticlePageVoOfUserId(page, userId);
        return page.getRecords();
    }

    @Override
    public List<TagTypeVO> getAllTags() {
        return articleMapper.queryTagTypeList();
    }

    @Override
    public void addArticle(Article article) {
        article.setId(null)
                .setCreateTime(null);
        this.save(article);
    }

}
