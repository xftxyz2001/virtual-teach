package com.xftxyz.virtualteach.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程表
 *
 * @TableName course
 */
@TableName(value = "course")
@Data
public class Course implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 课程ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 课程名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 课程介绍
     */
    @TableField(value = "introduction")
    private String introduction;
    /**
     * 部门ID
     */
    @TableField(value = "department_id")
    private Long departmentId;
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