package com.xftxyz.virtualteach.controller;

import com.xftxyz.virtualteach.domain.Department;
import com.xftxyz.virtualteach.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/list")
    public List<Department> getDepartmentList() {
        return departmentService.list();
    }
}
