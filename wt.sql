CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT PRIMARY KEY COMMENT '用户ID',
    `login` VARCHAR(255) COMMENT '用户名',
    `password` VARCHAR(255) COMMENT '密码',
    `nick_name` VARCHAR(255) COMMENT '用户昵称',
    `telephone` VARCHAR(255) COMMENT '电话号码',
    `teacher_name` VARCHAR(255) COMMENT '教师名',
    `personnel_signature` VARCHAR(255) COMMENT '个人签名',
    `department_id` BIGINT COMMENT '部门ID',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除'
) COMMENT = '用户表';

CREATE TABLE IF NOT EXISTS `department` (
    `id` BIGINT PRIMARY KEY COMMENT '部门ID',
    `name` VARCHAR(255) COMMENT '名称',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除'
) COMMENT = '部门表';

CREATE TABLE IF NOT EXISTS `teach_and_research_section` (
    `id` BIGINT PRIMARY KEY COMMENT '教研室ID',
    `name` VARCHAR(255) COMMENT '名称',
    `group_leader` BIGINT COMMENT '组长用户ID',
    `course_id` BIGINT COMMENT '课程ID',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除'
) COMMENT = '教研室表';

CREATE TABLE IF NOT EXISTS `section_user` (
    `id` BIGINT PRIMARY KEY COMMENT 'ID',
    `section_id` BIGINT COMMENT '教研室ID',
    `user_id` BIGINT COMMENT '用户ID',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除'
) COMMENT = '教研室用户关联表';

CREATE TABLE IF NOT EXISTS `course` (
    `id` BIGINT PRIMARY KEY COMMENT '课程ID',
    `name` VARCHAR(255) COMMENT '课程名称',
    `introduction` VARCHAR(255) COMMENT '课程介绍',
    `department_id` BIGINT COMMENT '部门ID',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除'
) COMMENT = '课程表';

CREATE TABLE IF NOT EXISTS `teacher_course` (
    `id` BIGINT PRIMARY KEY COMMENT 'ID',
    `user_id` BIGINT COMMENT '用户ID',
    `course_id` BIGINT COMMENT '课程ID',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除'
) COMMENT = '教师课程关联表';

CREATE TABLE IF NOT EXISTS `meeting` (
    `id` BIGINT PRIMARY KEY COMMENT '会议ID',
    `invite_num` VARCHAR(255) COMMENT '邀请码',
    `topic` VARCHAR(255) COMMENT '会议主题',
    `user_id` BIGINT COMMENT '用户ID',
    `start_time` TIMESTAMP COMMENT '开始时间',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除'
) COMMENT = '学术会议表';

CREATE TABLE IF NOT EXISTS `news` (
    `id` BIGINT PRIMARY KEY COMMENT '新闻ID',
    `topic` VARCHAR(255) COMMENT '主题',
    `content` VARCHAR(255) COMMENT '内容',
    -- `date` VARCHAR(255) COMMENT '日期',
    `publisher` BIGINT COMMENT '发布教研室ID',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除'
) COMMENT = '新闻公告表';

CREATE TABLE IF NOT EXISTS `system_notification` (
    `id` BIGINT PRIMARY KEY COMMENT '系统消息ID',
    `topic` VARCHAR(255) COMMENT '主题',
    `notification_type` VARCHAR(255) COMMENT '通知类型',
    `content` VARCHAR(255) COMMENT '内容',
    -- `date` VARCHAR(255) COMMENT '日期',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除'
) COMMENT = '系统消息表';
