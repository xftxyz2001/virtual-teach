package com.xftxyz.virtualteach.controller;


import com.xftxyz.virtualteach.config.Env;
import com.xftxyz.virtualteach.domain.News;
import com.xftxyz.virtualteach.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    // 获取新闻列表
    @GetMapping("/list")
    public List<News> getNewsList() {
        return newsService.list();
    }

    // 获取我已发布的新闻列表
    @GetMapping("/published")
    public List<News> getPublishedNewsList(@RequestAttribute(Env.USER_ID) Long userId) {
        return newsService.getPublishedNewsList(userId);
    }
}
