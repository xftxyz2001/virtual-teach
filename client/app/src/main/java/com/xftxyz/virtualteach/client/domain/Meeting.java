package com.xftxyz.virtualteach.client.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Meeting {
    /**
     * 会议ID
     */
    private Long id;
    /**
     * 邀请码
     */
    private String inviteNum;
    /**
     * 会议主题
     */
    private String topic;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}