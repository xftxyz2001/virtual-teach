package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class MyAdapterTeachResearchSection extends BaseAdapter {
    private Context context;
    private List<teach_and_research_section> data;

    public MyAdapterTeachResearchSection(List<teach_and_research_section> data2, Context context2) {
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
            view = LayoutInflater.from(this.context).inflate(R.layout.teach_research_section, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.course_name)).setText(this.data.get(i).getCourse_name());
        ((TextView) view.findViewById(R.id.section_num)).setText(this.data.get(i).getSection_num());
        return view;
    }
}
