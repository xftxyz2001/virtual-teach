package com.xftxyz.virtualteach.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.domain.Course;
import com.xftxyz.virtualteach.mapper.CourseMapper;
import com.xftxyz.virtualteach.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 25810
 * @description 针对表【course(课程表)】的数据库操作Service实现
 * @createDate 2024-05-13 14:37:33
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
        implements CourseService {

    @Override
    public List<Course> getCourseListByDepartmentId(Long departmentId) {
        return baseMapper.selectList(Wrappers.<Course>lambdaQuery()
                .eq(Course::getDepartmentId, departmentId));
    }
}




