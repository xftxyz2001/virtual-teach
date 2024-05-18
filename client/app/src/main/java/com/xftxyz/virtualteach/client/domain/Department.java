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
public class Department {
    /**
     * 部门ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public static Department parseDepartment(JSONObject jsonObject) throws JSONException {
        Department department = new Department();
        department.setId(jsonObject.getLong("id"));
        department.setName(jsonObject.getString("name"));
        department.setCreateTime(DateHelper.parse(jsonObject.getString("createTime")));
        department.setUpdateTime(DateHelper.parse(jsonObject.getString("updateTime")));
        return department;
    }

    public static List<Department> parseDepartmentArray(JSONArray jsonArray) throws JSONException {
        List<Department> departmentList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            departmentList.add(parseDepartment(jsonArray.getJSONObject(i)));
        }
        return departmentList;
    }
}