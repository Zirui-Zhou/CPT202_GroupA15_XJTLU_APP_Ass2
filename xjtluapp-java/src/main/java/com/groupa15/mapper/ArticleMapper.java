package com.groupa15.mapper;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.groupa15.entity.vo.ArticleScreenshotVO;

import com.groupa15.entity.Article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupa15.entity.vo.TagTypeVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

/**
 * @author Qi Xu
 * @date 2022/4/5
 */

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
//    @Insert("Insert into news (title, content) values (#{title}, #{content})")
//    int insert(News news);'

    Page<ArticleScreenshotVO> selectArticlePageVo(Page<ArticleScreenshotVO> iPage, @Param("viewerId") Long viewerId);

    @Select("SELECT * FROM student.article a INNER JOIN student.user b ON a.editor_id=b.user_id WHERE a.editor_id=#{userId} ORDER BY a.create_time DESC")
    Page<ArticleScreenshotVO> getArticlePageVoOfUserId(Page<ArticleScreenshotVO> iPage, Long userId);

    Page<ArticleScreenshotVO> selectArticlePageVoOfFavourite(Page<ArticleScreenshotVO> iPage, @Param("viewerId") Long viewerId);

    @Insert("INSERT INTO student.favourite_article(user_id, article_id) values(#{userId}, #{articleId})")
    Boolean insertFavouriteArticle(Long userId, Long articleId);

    @Delete("Delete FROM student.favourite_article WHERE user_id=#{userId} AND article_id=#{articleId}")
    Boolean deleteFavouriteArticle(Long userId, Long articleId);

    Boolean queryIsFavourite(@Param("viewerId") Long userId, @Param("articleId") Long articleId);

    List<TagTypeVO> queryTagTypeList();

}
