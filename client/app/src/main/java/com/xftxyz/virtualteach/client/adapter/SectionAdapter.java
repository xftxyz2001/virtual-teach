package com.xftxyz.virtualteach.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.domain.TeachAndResearchSection;

import java.util.List;

public class SectionAdapter extends BaseAdapter {
    private List<TeachAndResearchSection> sectionList;
    private LayoutInflater inflater;

    public SectionAdapter(Context context, List<TeachAndResearchSection> sectionList) {
        this.sectionList = sectionList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return sectionList.size();
    }

    @Override
    public TeachAndResearchSection getItem(int position) {
        return sectionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.section_item, parent, false);
            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.tv_section_course_name);
            holder.tvNumber = convertView.findViewById(R.id.tv_section_num);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TeachAndResearchSection section = sectionList.get(position);
        holder.tvName.setText(section.getName());
        holder.tvNumber.setText(String.valueOf(section.getId()));

        return convertView;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvNumber;
    }
}
