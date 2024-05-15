package com.xftxyz.virtualteach.controller;

import com.xftxyz.virtualteach.config.Env;
import com.xftxyz.virtualteach.domain.Course;
import com.xftxyz.virtualteach.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    // 通过部门ID获取课程列表
    @GetMapping("/list/{departmentId}")
    public List<Course> getCourseListByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        return courseService.getCourseListByDepartmentId(departmentId);
    }

    // 获取当前用户的课程列表
    @GetMapping("/teached")
    public List<Course> getTeachedCourseList(@RequestAttribute(Env.USER_ID) Long userId) {
        return courseService.getTeachedCourseList(userId);
    }
}
