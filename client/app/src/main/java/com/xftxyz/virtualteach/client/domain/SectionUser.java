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

    public static SectionUser parseSectionUser(JSONObject jsonObject) throws JSONException {
        SectionUser sectionUser = new SectionUser();
        sectionUser.setId(jsonObject.getLong("id"));
        sectionUser.setSectionId(jsonObject.getLong("sectionId"));
        sectionUser.setUserId(jsonObject.getLong("userId"));
        sectionUser.setCreateTime(DateHelper.parse(jsonObject.getString("createTime")));
        sectionUser.setUpdateTime(DateHelper.parse(jsonObject.getString("updateTime")));
        return sectionUser;
    }

    public static List<SectionUser> parseSectionUserArray(JSONArray jsonArray) throws JSONException {
        List<SectionUser> sectionUserList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            sectionUserList.add(parseSectionUser(jsonArray.getJSONObject(i)));
        }
        return sectionUserList;
    }
}