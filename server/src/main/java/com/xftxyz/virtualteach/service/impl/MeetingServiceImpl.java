package com.xftxyz.virtualteach.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.domain.Meeting;
import com.xftxyz.virtualteach.mapper.MeetingMapper;
import com.xftxyz.virtualteach.service.MeetingService;
import com.xftxyz.virtualteach.vo.req.CreateMeetingReq;
import org.springframework.stereotype.Service;

/**
 * @author 25810
 * @description 针对表【meeting(学术会议表)】的数据库操作Service实现
 * @createDate 2024-05-13 14:37:33
 */
@Service
public class MeetingServiceImpl extends ServiceImpl<MeetingMapper, Meeting>
        implements MeetingService {

    @Override
    public Meeting createMeeting(Long userId, CreateMeetingReq createMeetingReq) {
        Meeting meeting = Meeting.builder()
                .inviteNum(createMeetingReq.getInviteNum())
                .topic(createMeetingReq.getTopic())
                .startTime(createMeetingReq.getStartTime())
                .userId(userId)
                .build();
        baseMapper.insert(meeting);
        return meeting;
    }
}




