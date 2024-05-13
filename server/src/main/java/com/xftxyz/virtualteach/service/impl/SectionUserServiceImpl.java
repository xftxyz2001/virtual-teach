package com.xftxyz.virtualteach.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.domain.SectionUser;
import com.xftxyz.virtualteach.service.SectionUserService;
import com.xftxyz.virtualteach.mapper.SectionUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 25810
* @description 针对表【section_user(教研室用户关联表)】的数据库操作Service实现
* @createDate 2024-05-13 14:37:33
*/
@Service
public class SectionUserServiceImpl extends ServiceImpl<SectionUserMapper, SectionUser>
    implements SectionUserService{

}




