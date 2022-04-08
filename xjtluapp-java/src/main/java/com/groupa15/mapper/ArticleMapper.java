package com.groupa15.mapper;
import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.groupa15.entity.vo.ArticleScreenshotVO;

import com.groupa15.entity.Article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupa15.entity.vo.TagTypeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Qi Xu
 * @date 2022/4/5
 */

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
//    @Insert("Insert into news (title, content) values (#{title}, #{content})")
//    int insert(News news);'
    @Select("SELECT * from article a INNER JOIN user b on a.user_id=b.user_id")
    Page<ArticleScreenshotVO> getArticlePageVo(Page<ArticleScreenshotVO> iPage);

    List<TagTypeVO> queryTagTypeList();

}
