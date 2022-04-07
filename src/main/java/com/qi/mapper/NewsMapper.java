package com.qi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qi.entity.News;
import com.qi.entity.User;
import org.apache.ibatis.annotations.Insert;

public interface NewsMapper extends BaseMapper<News> {


    @Insert("Insert into news (title, content) values (#{title}, #{content})")
    int insert(News news);
}
