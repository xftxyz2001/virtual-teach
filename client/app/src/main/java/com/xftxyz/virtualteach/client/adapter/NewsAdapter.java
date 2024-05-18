package com.xftxyz.virtualteach.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.domain.News;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private List<News> newsList;
    private LayoutInflater inflater;

    public NewsAdapter(Context context, List<News> newsList) {
        this.newsList = newsList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public News getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.news_item, parent, false);
            holder = new ViewHolder();
            holder.tvTopic = convertView.findViewById(R.id.tv_news_item_topic);
            holder.tvDate = convertView.findViewById(R.id.tv_new_item_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        News news = newsList.get(position);
        holder.tvTopic.setText(news.getTopic());
        holder.tvDate.setText(news.getCreateTime().toString());

        return convertView;
    }

    static class ViewHolder {
        TextView tvTopic;
        TextView tvDate;
    }
}