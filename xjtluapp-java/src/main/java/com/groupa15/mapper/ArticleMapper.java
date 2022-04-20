package com.groupa15.mapper;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.groupa15.entity.vo.ArticleScreenshotVO;

import com.groupa15.entity.Article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupa15.entity.vo.ArticleTypeVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

/**
 * @author Qi Xu
 * @date 2022/4/5
 */

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    Page<ArticleScreenshotVO> selectArticlePageVo(Page<ArticleScreenshotVO> iPage, @Param("viewerId") Long viewerId);

    Page<ArticleScreenshotVO> selectArticlePageVoOfFavourite(Page<ArticleScreenshotVO> iPage, @Param("viewerId") Long viewerId);

    Page<ArticleScreenshotVO> selectArticlePageVoOfHistory(Page<ArticleScreenshotVO> iPage, @Param("viewerId") Long viewerId);

    Page<ArticleScreenshotVO> selectArticlePageVoOfMine(Page<ArticleScreenshotVO> iPage, @Param("viewerId") Long viewerId);

    Page<ArticleScreenshotVO> selectArticlePageVoOfType(Page<ArticleScreenshotVO> page, @Param("viewerId") Long viewerId, @Param("typeId")Long typeId);

    Page<ArticleScreenshotVO> selectArticlePageVoOfKeyword(Page<ArticleScreenshotVO> page, @Param("viewerId") Long viewerId, @Param("keyWord")String keyWord);

    @Insert("INSERT INTO xjtlu_app.article_favourite(user_id, article_id) values(#{userId}, #{articleId})")
    Boolean insertFavouriteArticle(Long userId, Long articleId);

    @Delete("Delete FROM xjtlu_app.article_favourite WHERE user_id=#{userId} AND article_id=#{articleId}")
    Boolean deleteFavouriteArticle(Long userId, Long articleId);

    @Insert("INSERT INTO xjtlu_app.article_history(user_id, article_id) values(#{userId}, #{articleId})")
    Boolean insertHistoryArticle(Long userId, Long articleId);

    @Delete("Delete FROM xjtlu_app.article_history WHERE user_id=#{userId} AND article_id=#{articleId}")
    Boolean deleteHistoryArticle(Long userId, Long articleId);

    Boolean queryIsFavourite(@Param("viewerId") Long userId, @Param("articleId") Long articleId);

    Boolean queryIsHistory(@Param("viewerId") Long userId, @Param("articleId") Long articleId);

    List<ArticleTypeVO> selectAllArticleTypes(@Param("lang") String lang);

}
