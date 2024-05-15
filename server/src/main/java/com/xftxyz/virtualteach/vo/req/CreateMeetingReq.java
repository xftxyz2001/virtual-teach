package com.xftxyz.virtualteach.vo.req;

import lombok.Data;

import java.util.Date;

@Data
public class CreateMeetingReq {

    private String inviteNum;
    private String topic;
    private Date startTime;
}
