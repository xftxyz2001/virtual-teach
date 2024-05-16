package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class MyAdapterCourse extends BaseAdapter {
    private Context context;
    private List<course> data;

    public MyAdapterCourse(List<course> data2, Context context2) {
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
            view = LayoutInflater.from(this.context).inflate(R.layout.course, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.course_name)).setText(this.data.get(i).getCourse_name());
        ((TextView) view.findViewById(R.id.teacher_name)).setText(this.data.get(i).getTeacher_name());
        return view;
    }
}
