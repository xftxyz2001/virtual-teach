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
public class TeachAndResearchSection {
    /**
     * 教研室ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 组长用户ID
     */
    private Long groupLeader;
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

    public static TeachAndResearchSection parseTeachAndResearchSection(JSONObject jsonObject) throws JSONException {
        TeachAndResearchSection teachAndResearchSection = new TeachAndResearchSection();
        teachAndResearchSection.setId(jsonObject.getLong("id"));
        teachAndResearchSection.setName(jsonObject.getString("name"));
        teachAndResearchSection.setGroupLeader(jsonObject.getLong("groupLeader"));
        teachAndResearchSection.setCourseId(jsonObject.getLong("courseId"));
        teachAndResearchSection.setCreateTime(DateHelper.parse(jsonObject.getString("createTime")));
        teachAndResearchSection.setUpdateTime(DateHelper.parse(jsonObject.getString("updateTime")));
        return teachAndResearchSection;
    }

    public static List<TeachAndResearchSection> parseTeachAndResearchSectionArray(JSONArray jsonArray) throws JSONException {
        List<TeachAndResearchSection> teachAndResearchSectionList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            teachAndResearchSectionList.add(parseTeachAndResearchSection(jsonArray.getJSONObject(i)));
        }
        return teachAndResearchSectionList;
    }
}