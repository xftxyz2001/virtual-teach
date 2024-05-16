package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class MyNewsListAdapter extends BaseAdapter {
    private Context context;
    private List<news_list> data;

    public MyNewsListAdapter(List<news_list> data2, Context context2) {
        this.data = data2;
        this.context = context2;
    }

    public int getCount() {
        return this.data.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.news, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.news_topic)).setText(this.data.get(i).getNews_topic());
        ((TextView) view.findViewById(R.id.new_date)).setText(this.data.get(i).getNews_date());
        return view;
    }
}
