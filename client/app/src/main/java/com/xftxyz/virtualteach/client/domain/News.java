package com.xftxyz.virtualteach.client.domain;

import java.util.Date;

import lombok.Data;

@Data
public class News {
    /**
     * 新闻ID
     */
    private Long id;
    /**
     * 主题
     */
    private String topic;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布教研室ID
     */
    private Long publisher;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}