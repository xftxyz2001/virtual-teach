package com.xftxyz.virtualteach.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.domain.News;
import com.xftxyz.virtualteach.domain.TeachAndResearchSection;
import com.xftxyz.virtualteach.mapper.NewsMapper;
import com.xftxyz.virtualteach.mapper.TeachAndResearchSectionMapper;
import com.xftxyz.virtualteach.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 25810
 * @description 针对表【news(新闻公告表)】的数据库操作Service实现
 * @createDate 2024-05-13 14:37:33
 */
@Service
@RequiredArgsConstructor
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News>
        implements NewsService {

    private final TeachAndResearchSectionMapper teachAndResearchSectionMapper;

    @Override
    public List<News> getPublishedNewsList(Long userId) {
        List<TeachAndResearchSection> createdSections = teachAndResearchSectionMapper.selectList(
                Wrappers.<TeachAndResearchSection>lambdaQuery().eq(TeachAndResearchSection::getGroupLeader, userId));
        return baseMapper.selectList(Wrappers.<News>lambdaQuery()
                .in(News::getPublisher, createdSections.stream().map(TeachAndResearchSection::getId).toList()));
    }
}




