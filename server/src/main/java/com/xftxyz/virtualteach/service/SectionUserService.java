package com.xftxyz.virtualteach.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xftxyz.virtualteach.domain.SectionUser;
import com.xftxyz.virtualteach.vo.req.JoinSectionReq;

/**
 * @author 25810
 * @description 针对表【section_user(教研室用户关联表)】的数据库操作Service
 * @createDate 2024-05-13 14:37:33
 */
public interface SectionUserService extends IService<SectionUser> {

    Boolean joinSection(Long userId, JoinSectionReq joinSectionReq);
}
