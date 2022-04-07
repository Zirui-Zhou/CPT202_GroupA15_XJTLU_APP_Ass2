package com.qi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qi.entity.News;
import com.qi.entity.User;
import com.qi.mapper.NewsMapper;
import org.springframework.stereotype.Service;

@Service
public class NewsService extends ServiceImpl<NewsMapper, News> {


    public boolean saveNews(News news){
        return saveOrUpdate(news);
    }

    public IPage<News> findPage(Integer pageNum, Integer pageSize, String title, String content){
        IPage<News> page = new Page<>(pageNum, pageSize);
        QueryWrapper<News> wrapper = new QueryWrapper<>();
        //如果不判断，会将""作为查询条件，将无法查询到此值为null的数据
        if(!title.equals("")) wrapper.like("title", title);
        if(!content.equals("")) wrapper.like("content", content);

        return page(page, wrapper);
    }

}
