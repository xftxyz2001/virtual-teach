package com.xftxyz.virtualteach.client.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TeacherCourse {
    /**
     * ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
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