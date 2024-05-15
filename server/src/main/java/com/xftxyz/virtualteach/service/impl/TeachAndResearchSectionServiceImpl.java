package com.xftxyz.virtualteach.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.domain.Course;
import com.xftxyz.virtualteach.domain.SectionUser;
import com.xftxyz.virtualteach.domain.TeachAndResearchSection;
import com.xftxyz.virtualteach.exception.BusinessException;
import com.xftxyz.virtualteach.mapper.CourseMapper;
import com.xftxyz.virtualteach.mapper.SectionUserMapper;
import com.xftxyz.virtualteach.mapper.TeachAndResearchSectionMapper;
import com.xftxyz.virtualteach.result.ResultEnum;
import com.xftxyz.virtualteach.service.TeachAndResearchSectionService;
import com.xftxyz.virtualteach.vo.req.CreateSectionReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author 25810
 * @description 针对表【teach_and_research_section(教研室表)】的数据库操作Service实现
 * @createDate 2024-05-13 14:37:33
 */
@Service
@RequiredArgsConstructor
public class TeachAndResearchSectionServiceImpl extends ServiceImpl<TeachAndResearchSectionMapper, TeachAndResearchSection>
        implements TeachAndResearchSectionService {

    private final CourseMapper courseMapper;
    private final SectionUserMapper sectionUserMapper;

    @Override
    public Boolean createSection(Long userId, CreateSectionReq createSectionReq) {
        Long courseId = createSectionReq.getCourseId();
        Course course = courseMapper.selectOne(Wrappers.<Course>lambdaQuery()
                .eq(Course::getId, courseId));
        if (ObjectUtils.isEmpty(course)) {
            BusinessException.throwOf(ResultEnum.COURSE_NOT_EXIST);
        }
        TeachAndResearchSection section = TeachAndResearchSection.builder()
                .courseId(courseId)
                .name(createSectionReq.getName())
                .groupLeader(userId)
                .build();
        baseMapper.insert(section);

        sectionUserMapper.insert(SectionUser.builder()
                .sectionId(section.getId())
                .userId(userId)
                .build());
        return Boolean.TRUE;
    }

    @Override
    public List<TeachAndResearchSection> getCreatedSectionList(Long userId) {
        return baseMapper.selectList(Wrappers.<TeachAndResearchSection>lambdaQuery()
                .eq(TeachAndResearchSection::getGroupLeader, userId));
    }
}




