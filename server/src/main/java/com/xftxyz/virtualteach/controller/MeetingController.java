package com.xftxyz.virtualteach.controller;

import com.xftxyz.virtualteach.config.Env;
import com.xftxyz.virtualteach.domain.Meeting;
import com.xftxyz.virtualteach.service.MeetingService;
import com.xftxyz.virtualteach.vo.req.CreateMeetingReq;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/meeting")
public class MeetingController {

    private final MeetingService meetingService;

    // 发起会议
    @PostMapping("/create")
    public Meeting createMeeting(@RequestAttribute(Env.USER_ID) Long userId, @RequestBody CreateMeetingReq createMeetingReq) {
        return meetingService.createMeeting(userId, createMeetingReq);
    }
}

