package com.groupa15.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.groupa15.entity.News;
import org.springframework.stereotype.Service;

@Service
public interface NewsService extends IService<News> {

    boolean saveNews(News news);
    IPage<News> findPage(Integer pageNum, Integer pageSize, String title, String content);

}
