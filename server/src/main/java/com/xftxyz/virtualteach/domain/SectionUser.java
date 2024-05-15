package com.xftxyz.virtualteach.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 教研室用户关联表
 *
 * @TableName section_user
 */
@TableName(value = "section_user")
@Data
@Builder
public class SectionUser implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 教研室ID
     */
    @TableField(value = "section_id")
    private Long sectionId;
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    private Integer deleted;
}