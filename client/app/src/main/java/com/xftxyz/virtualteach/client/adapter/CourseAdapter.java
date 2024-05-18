package com.xftxyz.virtualteach.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.domain.Course;

import java.util.List;

public class CourseAdapter extends BaseAdapter {
    private List<Course> courseList;
    private LayoutInflater inflater;

    public CourseAdapter(Context context, List<Course> courseList) {
        this.courseList = courseList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Course getItem(int position) {
        return courseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.course_item, parent, false);
            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.tv_course_item_name);
            holder.tvTeacher = convertView.findViewById(R.id.tv_course_item_teacher_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Course course = courseList.get(position);
        holder.tvName.setText(course.getName());
        holder.tvTeacher.setText(course.getName()); // TODO: Course中没有teacher字段

        return convertView;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvTeacher;
    }
}
