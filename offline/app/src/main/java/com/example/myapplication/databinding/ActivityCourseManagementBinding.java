package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityCourseManagementBinding implements ViewBinding {
    public final ListView lvMyCourse;
    private final ConstraintLayout rootView;

    private ActivityCourseManagementBinding(ConstraintLayout rootView2, ListView lvMyCourse2) {
        this.rootView = rootView2;
        this.lvMyCourse = lvMyCourse2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCourseManagementBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityCourseManagementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_course_management, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityCourseManagementBinding bind(View rootView2) {
        ListView lvMyCourse2 = (ListView) ViewBindings.findChildViewById(rootView2, R.id.lv_my_course);
        if (lvMyCourse2 != null) {
            return new ActivityCourseManagementBinding((ConstraintLayout) rootView2, lvMyCourse2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.lv_my_course)));
    }
}
