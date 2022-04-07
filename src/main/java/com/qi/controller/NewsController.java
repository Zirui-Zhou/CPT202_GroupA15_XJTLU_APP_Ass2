package com.qi.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qi.entity.News;
import com.qi.entity.User;
import com.qi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<News> findAll(){
        return newsService.list();
    }

    @PostMapping
    public boolean saveNews(@RequestBody News news){
        return newsService.saveNews(news);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return newsService.removeById(id);
    }

    @GetMapping("/page")
    public IPage<News> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam (defaultValue = "") String title,
                                @RequestParam (defaultValue = "") String content){
        return newsService.findPage(pageNum, pageSize, title, content);
    }

}
