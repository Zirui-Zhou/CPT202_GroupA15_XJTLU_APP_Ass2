package com.groupa15.mapper;

import com.groupa15.entity.News;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

public interface NewsMapper extends BaseMapper<News> {
    @Insert("Insert into news (title, content) values (#{title}, #{content})")
    int insert(News news);
}
