package com.xftxyz.virtualteach.client.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Course {
    /**
     * 课程ID
     */
    private Long id;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程介绍
     */
    private String introduction;
    /**
     * 部门ID
     */
    private Long departmentId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}