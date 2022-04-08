package com.groupa15.mapper;

import com.groupa15.entity.Article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Qi Xu
 * @date 2022/4/5
 */

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
//    @Insert("Insert into news (title, content) values (#{title}, #{content})")
//    int insert(News news);
}
