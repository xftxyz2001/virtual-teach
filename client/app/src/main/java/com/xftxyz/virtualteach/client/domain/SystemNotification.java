package com.xftxyz.virtualteach.client.domain;

import com.xftxyz.virtualteach.client.util.DateHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class SystemNotification {
    /**
     * 系统消息ID
     */
    private Long id;
    /**
     * 主题
     */
    private String topic;
    /**
     * 通知类型
     */
    private String notificationType;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public static SystemNotification parseSystemNotification(JSONObject systemNotificationObject) throws JSONException {
        SystemNotification systemNotification = new SystemNotification();
        systemNotification.setId(systemNotificationObject.getLong("id"));
        systemNotification.setTopic(systemNotificationObject.getString("topic"));
        systemNotification.setNotificationType(systemNotificationObject.getString("notificationType"));
        systemNotification.setContent(systemNotificationObject.getString("content"));
        systemNotification.setCreateTime(DateHelper.parse(systemNotificationObject.getString("createTime")));
        systemNotification.setUpdateTime(DateHelper.parse(systemNotificationObject.getString("updateTime")));
        return systemNotification;
    }

    public static List<SystemNotification> parseSystemNotificationArray(JSONArray systemNotificationArray) throws JSONException {
        List<SystemNotification> systemNotificationList = new ArrayList<>();
        for (int i = 0; i < systemNotificationArray.length(); i++) {
            systemNotificationList.add(parseSystemNotification(systemNotificationArray.getJSONObject(i)));
        }
        return systemNotificationList;
    }
}