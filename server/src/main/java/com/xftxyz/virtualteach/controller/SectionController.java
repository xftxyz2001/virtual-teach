package com.xftxyz.virtualteach.controller;

import com.xftxyz.virtualteach.config.Env;
import com.xftxyz.virtualteach.domain.TeachAndResearchSection;
import com.xftxyz.virtualteach.service.SectionUserService;
import com.xftxyz.virtualteach.service.TeachAndResearchSectionService;
import com.xftxyz.virtualteach.vo.req.CreateSectionReq;
import com.xftxyz.virtualteach.vo.req.JoinSectionReq;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/section")
public class SectionController {

    private SectionUserService sectionUserService;
    private TeachAndResearchSectionService teachAndResearchSectionService;

    // 加入教研室
    @PostMapping("/join")
    public Boolean joinSection(@RequestAttribute(Env.USER_ID) Long userId, JoinSectionReq joinSectionReq) {
        return sectionUserService.joinSection(userId, joinSectionReq);
    }

    // 创建教研室
    @PostMapping("/create")
    public Boolean createSection(@RequestAttribute(Env.USER_ID) Long userId, CreateSectionReq createSectionReq) {
        return teachAndResearchSectionService.createSection(userId, createSectionReq);
    }

    // 获取加入的教研室列表
    @GetMapping("/joined")
    public List<TeachAndResearchSection> getJoinedSectionList(@RequestAttribute(Env.USER_ID) Long userId) {
        return sectionUserService.getJoinedSectionList(userId);
    }

    // 获取创建的教研室列表
    @GetMapping("/created")
    public List<TeachAndResearchSection> getCreatedSectionList(@RequestAttribute(Env.USER_ID) Long userId) {
        return teachAndResearchSectionService.getCreatedSectionList(userId);
    }

}
