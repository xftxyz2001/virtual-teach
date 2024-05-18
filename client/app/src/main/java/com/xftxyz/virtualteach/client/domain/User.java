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

    public static User parseUser(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.setId(jsonObject.getLong("id"));
        user.setLogin(jsonObject.getString("login"));
        user.setPassword(jsonObject.getString("password"));
        user.setNickName(jsonObject.getString("nickName"));
        user.setTelephone(jsonObject.getString("telephone"));
        user.setTeacherName(jsonObject.getString("teacherName"));
        user.setPersonnelSignature(jsonObject.getString("personnelSignature"));
        user.setDepartmentId(jsonObject.getLong("departmentId"));
        user.setCreateTime(DateHelper.parse(jsonObject.getString("createTime")));
        user.setUpdateTime(DateHelper.parse(jsonObject.getString("updateTime")));
        return user;
    }

    public static List<User> parseUserArray(JSONArray jsonArray) throws JSONException {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            userList.add(parseUser(jsonArray.getJSONObject(i)));
        }
        return userList;
    }
}