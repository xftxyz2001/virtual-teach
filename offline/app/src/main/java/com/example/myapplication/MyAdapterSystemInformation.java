package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class MyAdapterSystemInformation extends BaseAdapter {
    private Context context;
    private List<system_information> data;

    public MyAdapterSystemInformation(List<system_information> data2, Context context2) {
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
            view = LayoutInflater.from(this.context).inflate(R.layout.system_information, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.system_information_type)).setText(this.data.get(i).getInformation_type());
        ((TextView) view.findViewById(R.id.release_time)).setText(this.data.get(i).getDate());
        ((TextView) view.findViewById(R.id.information_topic)).setText(this.data.get(i).getInformation_topic());
        return view;
    }
}
