package com.xftxyz.virtualteach.client.domain;

import java.util.Date;

import lombok.Data;

@Data
public class SystemNotification {
    /**
     * 系统消息ID
     */
    private Long id;
    /**
     * 主题
     */
    private String topic;
    /**
     * 通知类型
     */
    private String notificationType;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}