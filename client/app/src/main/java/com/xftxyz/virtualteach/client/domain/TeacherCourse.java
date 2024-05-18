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
public class TeacherCourse {
    /**
     * ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
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

    public static TeacherCourse parseTeacherCourse(JSONObject jsonObject) throws JSONException {
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.setId(jsonObject.getLong("id"));
        teacherCourse.setUserId(jsonObject.getLong("userId"));
        teacherCourse.setCourseId(jsonObject.getLong("courseId"));
        teacherCourse.setCreateTime(DateHelper.parse(jsonObject.getString("createTime")));
        teacherCourse.setUpdateTime(DateHelper.parse(jsonObject.getString("updateTime")));
        return teacherCourse;
    }

    public static List<TeacherCourse> parseTeacherCourseArray(JSONArray jsonArray) throws JSONException {
        List<TeacherCourse> teacherCourseList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            teacherCourseList.add(parseTeacherCourse(jsonArray.getJSONObject(i)));
        }
        return teacherCourseList;
    }
}