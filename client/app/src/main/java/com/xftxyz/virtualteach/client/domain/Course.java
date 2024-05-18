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
public class Course {
    /**
     * 课程ID
     */
    private Long id;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程介绍
     */
    private String introduction;
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

    public static Course parseCourse(JSONObject jsonObject) throws JSONException {
        Course course = new Course();
        course.setId(jsonObject.getLong("id"));
        course.setName(jsonObject.getString("name"));
        course.setIntroduction(jsonObject.getString("introduction"));
        course.setDepartmentId(jsonObject.getLong("departmentId"));
        course.setCreateTime(DateHelper.parse(jsonObject.getString("createTime")));
        course.setUpdateTime(DateHelper.parse(jsonObject.getString("updateTime")));
        return course;
    }

    public static List<Course> parseCourseArray(JSONArray jsonArray) throws JSONException {
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            courseList.add(parseCourse(jsonArray.getJSONObject(i)));
        }
        return courseList;
    }
}