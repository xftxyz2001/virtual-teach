package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class TeachResearchSectionBinding implements ViewBinding {
    public final TextView courseName;
    private final LinearLayout rootView;
    public final TextView sectionNum;

    private TeachResearchSectionBinding(LinearLayout rootView2, TextView courseName2, TextView sectionNum2) {
        this.rootView = rootView2;
        this.courseName = courseName2;
        this.sectionNum = sectionNum2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TeachResearchSectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static TeachResearchSectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.teach_research_section, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static TeachResearchSectionBinding bind(View rootView2) {
        int id = R.id.course_name;
        TextView courseName2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.course_name);
        if (courseName2 != null) {
            id = R.id.section_num;
            TextView sectionNum2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.section_num);
            if (sectionNum2 != null) {
                return new TeachResearchSectionBinding((LinearLayout) rootView2, courseName2, sectionNum2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
