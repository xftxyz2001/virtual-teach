package com.xftxyz.virtualteach.client.domain;

import java.util.Date;

import lombok.Data;

@Data
public class SectionUser {
    /**
     * ID
     */
    private Long id;
    /**
     * 教研室ID
     */
    private Long sectionId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}