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
public class News {
    /**
     * 新闻ID
     */
    private Long id;
    /**
     * 主题
     */
    private String topic;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布教研室ID
     */
    private Long publisher;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public static News parseNews(JSONObject newsObject) throws JSONException {
        News news = new News();
        news.setId(newsObject.getLong("id"));
        news.setTopic(newsObject.getString("topic"));
        news.setContent(newsObject.getString("content"));
        news.setPublisher(newsObject.getLong("publisher"));
        news.setCreateTime(DateHelper.parse(newsObject.getString("createTime")));
        news.setUpdateTime(DateHelper.parse(newsObject.getString("updateTime")));
        return news;
    }

    public static List<News> parseNewsArray(JSONArray newsArray) throws JSONException {
        List<News> newsList = new ArrayList<>();
        for (int i = 0; i < newsArray.length(); i++) {
            newsList.add(parseNews(newsArray.getJSONObject(i)));
        }
        return newsList;
    }
}