package com.xftxyz.virtualteach.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.domain.Course;
import com.xftxyz.virtualteach.domain.TeacherCourse;
import com.xftxyz.virtualteach.mapper.CourseMapper;
import com.xftxyz.virtualteach.mapper.TeacherCourseMapper;
import com.xftxyz.virtualteach.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 25810
 * @description 针对表【course(课程表)】的数据库操作Service实现
 * @createDate 2024-05-13 14:37:33
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
        implements CourseService {

    private final TeacherCourseMapper teacherCourseMapper;

    @Override
    public List<Course> getCourseListByDepartmentId(Long departmentId) {
        return baseMapper.selectList(Wrappers.<Course>lambdaQuery()
                .eq(Course::getDepartmentId, departmentId));
    }

    @Override
    public List<Course> getTeachedCourseList(Long userId) {
        List<TeacherCourse> teacherCourses = teacherCourseMapper.selectList(Wrappers.<TeacherCourse>lambdaQuery()
                .eq(TeacherCourse::getUserId, userId));
        return baseMapper.selectBatchIds(teacherCourses.stream().map(TeacherCourse::getCourseId).toList());
    }
}




