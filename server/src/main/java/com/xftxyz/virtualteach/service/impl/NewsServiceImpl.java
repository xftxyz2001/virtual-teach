package com.xftxyz.virtualteach.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.domain.News;
import com.xftxyz.virtualteach.service.NewsService;
import com.xftxyz.virtualteach.mapper.NewsMapper;
import org.springframework.stereotype.Service;

/**
* @author 25810
* @description 针对表【news(新闻公告表)】的数据库操作Service实现
* @createDate 2024-05-13 14:37:33
*/
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News>
    implements NewsService{

}




