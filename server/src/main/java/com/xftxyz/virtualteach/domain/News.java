package com.xftxyz.virtualteach.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻公告表
 *
 * @TableName news
 */
@TableName(value = "news")
@Data
public class News implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 新闻ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 主题
     */
    @TableField(value = "topic")
    private String topic;
    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;
    /**
     * 发布教研室ID
     */
    @TableField(value = "publisher")
    private Long publisher;
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