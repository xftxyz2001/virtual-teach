package com.xftxyz.virtualteach.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.domain.Department;
import com.xftxyz.virtualteach.service.DepartmentService;
import com.xftxyz.virtualteach.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

/**
* @author 25810
* @description 针对表【department(部门表)】的数据库操作Service实现
* @createDate 2024-05-13 14:37:33
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService{

}




