package com.xftxyz.virtualteach.controller;

import com.xftxyz.virtualteach.domain.Course;
import com.xftxyz.virtualteach.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
