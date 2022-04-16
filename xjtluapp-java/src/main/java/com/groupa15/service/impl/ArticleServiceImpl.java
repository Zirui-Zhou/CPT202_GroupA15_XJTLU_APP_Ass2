package com.groupa15.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupa15.common.dto.ArticlePageDto;
import com.groupa15.entity.Article;
import com.groupa15.entity.vo.ArticleScreenshotVO;
import com.groupa15.entity.vo.ArticleTypeVO;
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
    public List<ArticleScreenshotVO> getArticlePage(ArticlePageDto articlePageDto, Long viewerId) {
        Page<ArticleScreenshotVO> page = new Page<>(articlePageDto.getCurrent(), articlePageDto.getSize());
        page = articleMapper.selectArticlePageVo(page, viewerId);
        return page.getRecords();
    }

    @Override
    public List<ArticleScreenshotVO> getArticlePageOfUserId(ArticlePageDto articlePageDto, Long userId) {
        Page<ArticleScreenshotVO> page = new Page<>(articlePageDto.getCurrent(), articlePageDto.getSize());
        page = articleMapper.selectArticlePageVoOfMine(page, userId);
        return page.getRecords();
    }

    @Override
    public List<ArticleScreenshotVO> getArticlePageOfFavourite(ArticlePageDto articlePageDto, Long viewerId) {
        Page<ArticleScreenshotVO> page = new Page<>(articlePageDto.getCurrent(), articlePageDto.getSize());
        page = articleMapper.selectArticlePageVoOfFavourite(page, viewerId);
        return page.getRecords();
    }

    @Override
    public List<ArticleScreenshotVO> getArticlePageOfHistory(ArticlePageDto articlePageDto, Long viewerId) {
        Page<ArticleScreenshotVO> page = new Page<>(articlePageDto.getCurrent(), articlePageDto.getSize());
        page = articleMapper.selectArticlePageVoOfHistory(page, viewerId);
        return page.getRecords();
    }

    @Override
    public List<ArticleScreenshotVO> getArticlePageOfKeyWord(ArticlePageDto articlePageDto, Long viewerId, String keyWord) {
        Page<ArticleScreenshotVO> page = new Page<>(articlePageDto.getCurrent(), articlePageDto.getSize());
        page = articleMapper.selectArticlePageVoOfKeyword(page, viewerId, keyWord);
        return page.getRecords();
    }

    @Override
    public List<ArticleScreenshotVO> getArticlePageOfType(ArticlePageDto articlePageDto, Long viewerId, Long typeId) {
        Page<ArticleScreenshotVO> page = new Page<>(articlePageDto.getCurrent(), articlePageDto.getSize());
        page = articleMapper.selectArticlePageVoOfType(page, viewerId, typeId);
        return page.getRecords();
    }

    @Override
    public Boolean changeFavouriteArticle(Long userId, Long articleId) {
        Boolean result = false;
        if(articleMapper.queryIsFavourite(userId, articleId)) {
            result = articleMapper.deleteFavouriteArticle(userId, articleId);
        } else {
            result = articleMapper.insertFavouriteArticle(userId, articleId);
        }
        return result;
    }

    @Override
    public Boolean addHistoryArticle(Long userId, Long articleId) {
        Boolean result = false;
        if(!articleMapper.queryIsHistory(userId, articleId)) {
            result = articleMapper.insertHistoryArticle(userId, articleId);
        }
        return result;
    }

    @Override
    public Boolean removeHistoryArticle(Long userId, Long articleId) {
        Boolean result = false;
        if(articleMapper.queryIsHistory(userId, articleId)) {
            result = articleMapper.deleteHistoryArticle(userId, articleId);
        }
        return result;
    }

    @Override
    public List<ArticleTypeVO> getAllArticleTypes() {
        return articleMapper.selectAllArticleTypes();
    }

    @Override
    public void addArticle(Article article) {
        article.setId(null)
                .setCreateTime(null);
        this.save(article);
    }

}
