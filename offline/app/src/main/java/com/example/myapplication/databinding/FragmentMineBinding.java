package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class FragmentMineBinding implements ViewBinding {
    public final Button courseManagement;
    public final Button editPersonalInfo;
    public final Button homeworkManagement;
    private final ConstraintLayout rootView;
    public final Button setting;

    private FragmentMineBinding(ConstraintLayout rootView2, Button courseManagement2, Button editPersonalInfo2, Button homeworkManagement2, Button setting2) {
        this.rootView = rootView2;
        this.courseManagement = courseManagement2;
        this.editPersonalInfo = editPersonalInfo2;
        this.homeworkManagement = homeworkManagement2;
        this.setting = setting2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMineBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static FragmentMineBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_mine, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentMineBinding bind(View rootView2) {
        int id = R.id.course_management;
        Button courseManagement2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.course_management);
        if (courseManagement2 != null) {
            id = R.id.edit_personal_info;
            Button editPersonalInfo2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.edit_personal_info);
            if (editPersonalInfo2 != null) {
                id = R.id.homework_management;
                Button homeworkManagement2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.homework_management);
                if (homeworkManagement2 != null) {
                    id = R.id.setting;
                    Button setting2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.setting);
                    if (setting2 != null) {
                        return new FragmentMineBinding((ConstraintLayout) rootView2, courseManagement2, editPersonalInfo2, homeworkManagement2, setting2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
