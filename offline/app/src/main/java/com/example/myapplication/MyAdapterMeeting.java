package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class MyAdapterMeeting extends BaseAdapter {
    private Context context;
    private List<meeting> data;

    public MyAdapterMeeting(List<meeting> data2, Context context2) {
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
            view = LayoutInflater.from(this.context).inflate(R.layout.meeting_item, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.meeting_topic)).setText(this.data.get(i).getMeetingTopic());
        ((TextView) view.findViewById(R.id.meeting_startTime)).setText(this.data.get(i).getStartDate().toString());
        ((TextView) view.findViewById(R.id.meeting_num)).setText(this.data.get(i).getMeetingNum());
        return view;
    }
}
