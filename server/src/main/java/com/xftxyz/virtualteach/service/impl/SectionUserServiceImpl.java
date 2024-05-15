package com.xftxyz.virtualteach.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.domain.SectionUser;
import com.xftxyz.virtualteach.exception.BusinessException;
import com.xftxyz.virtualteach.mapper.SectionUserMapper;
import com.xftxyz.virtualteach.result.ResultEnum;
import com.xftxyz.virtualteach.service.SectionUserService;
import com.xftxyz.virtualteach.vo.req.JoinSectionReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author 25810
 * @description 针对表【section_user(教研室用户关联表)】的数据库操作Service实现
 * @createDate 2024-05-13 14:37:33
 */
@Service
@RequiredArgsConstructor
public class SectionUserServiceImpl extends ServiceImpl<SectionUserMapper, SectionUser>
        implements SectionUserService {

    @Override
    public Boolean joinSection(Long userId, JoinSectionReq joinSectionReq) {
        Long sectionId = joinSectionReq.getSectionId();

        SectionUser sectionUser = baseMapper.selectOne(Wrappers.<SectionUser>lambdaQuery()
                .eq(SectionUser::getUserId, userId)
                .eq(SectionUser::getSectionId, sectionId));
        if (!ObjectUtils.isEmpty(sectionUser)) {
            BusinessException.throwOf(ResultEnum.USER_ALREADY_JOINED_SECTION);
        }
        baseMapper.insert(SectionUser.builder()
                .sectionId(sectionId)
                .userId(userId)
                .build());
        return Boolean.TRUE;
    }

}




