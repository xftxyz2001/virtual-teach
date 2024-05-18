package com.xftxyz.virtualteach.client.domain;

import java.util.Date;

import lombok.Data;

@Data
public class User {
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String login;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 电话号码
     */
    private String telephone;
    /**
     * 教师名
     */
    private String teacherName;
    /**
     * 个人签名
     */
    private String personnelSignature;
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