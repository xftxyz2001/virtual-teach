package com.xftxyz.virtualteach.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xftxyz.virtualteach.domain.TeachAndResearchSection;
import com.xftxyz.virtualteach.vo.req.CreateSectionReq;

import java.util.List;

/**
 * @author 25810
 * @description 针对表【teach_and_research_section(教研室表)】的数据库操作Service
 * @createDate 2024-05-13 14:37:33
 */
public interface TeachAndResearchSectionService extends IService<TeachAndResearchSection> {

    Boolean createSection(Long userId, CreateSectionReq createSectionReq);

    List<TeachAndResearchSection> getCreatedSectionList(Long userId);
}
