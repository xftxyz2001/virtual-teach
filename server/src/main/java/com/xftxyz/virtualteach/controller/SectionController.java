package com.xftxyz.virtualteach.controller;

import com.xftxyz.virtualteach.config.Env;
import com.xftxyz.virtualteach.service.SectionUserService;
import com.xftxyz.virtualteach.service.TeachAndResearchSectionService;
import com.xftxyz.virtualteach.vo.req.CreateSectionReq;
import com.xftxyz.virtualteach.vo.req.JoinSectionReq;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/section")
public class SectionController {

    private SectionUserService sectionUserService;
    private TeachAndResearchSectionService teachAndResearchSectionService;

    @PostMapping("/join")
    public Boolean joinSection(@RequestAttribute(Env.USER_ID) Long userId, JoinSectionReq joinSectionReq) {
        return sectionUserService.joinSection(userId, joinSectionReq);
    }

    @PostMapping("/create")
    public Boolean createSection(@RequestAttribute(Env.USER_ID) Long userId, CreateSectionReq createSectionReq) {
        return teachAndResearchSectionService.createSection(userId, createSectionReq);
    }

}
