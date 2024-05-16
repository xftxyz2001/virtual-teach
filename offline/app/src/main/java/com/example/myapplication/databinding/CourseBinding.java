package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class CourseBinding implements ViewBinding {
    public final TextView courseName;
    private final LinearLayout rootView;
    public final TextView teacherName;

    private CourseBinding(LinearLayout rootView2, TextView courseName2, TextView teacherName2) {
        this.rootView = rootView2;
        this.courseName = courseName2;
        this.teacherName = teacherName2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CourseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static CourseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.course, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static CourseBinding bind(View rootView2) {
        int id = R.id.course_name;
        TextView courseName2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.course_name);
        if (courseName2 != null) {
            id = R.id.teacher_name;
            TextView teacherName2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.teacher_name);
            if (teacherName2 != null) {
                return new CourseBinding((LinearLayout) rootView2, courseName2, teacherName2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
