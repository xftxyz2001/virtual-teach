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
public class Meeting {
    /**
     * 会议ID
     */
    private Long id;
    /**
     * 邀请码
     */
    private String inviteNum;
    /**
     * 会议主题
     */
    private String topic;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public static Meeting parseMeeting(JSONObject jsonObject) throws JSONException {
        Meeting meeting = new Meeting();
        meeting.setId(jsonObject.getLong("id"));
        meeting.setInviteNum(jsonObject.getString("inviteNum"));
        meeting.setTopic(jsonObject.getString("topic"));
        meeting.setUserId(jsonObject.getLong("userId"));
        meeting.setStartTime(DateHelper.parse(jsonObject.getString("startTime")));
        meeting.setCreateTime(DateHelper.parse(jsonObject.getString("createTime")));
        meeting.setUpdateTime(DateHelper.parse(jsonObject.getString("updateTime")));
        return meeting;
    }

    public static List<Meeting> parseMeetingArray(JSONArray jsonArray) throws JSONException {
        List<Meeting> meetingList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            meetingList.add(parseMeeting(jsonArray.getJSONObject(i)));
        }
        return meetingList;
    }

}