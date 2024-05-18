package com.xftxyz.virtualteach.client.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TeachAndResearchSection {
    /**
     * 教研室ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 组长用户ID
     */
    private Long groupLeader;
    /**
     * 课程ID
     */
    private Long courseId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}