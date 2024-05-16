package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityJoinTeachResearchSectionBinding implements ViewBinding {
    public final EditText joinSectionNum;
    public final EditText joinTeacherName;
    public final EditText joinTeacherNum;
    private final ConstraintLayout rootView;

    private ActivityJoinTeachResearchSectionBinding(ConstraintLayout rootView2, EditText joinSectionNum2, EditText joinTeacherName2, EditText joinTeacherNum2) {
        this.rootView = rootView2;
        this.joinSectionNum = joinSectionNum2;
        this.joinTeacherName = joinTeacherName2;
        this.joinTeacherNum = joinTeacherNum2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityJoinTeachResearchSectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityJoinTeachResearchSectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_join_teach_research_section, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityJoinTeachResearchSectionBinding bind(View rootView2) {
        int id = R.id.join_section_num;
        EditText joinSectionNum2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.join_section_num);
        if (joinSectionNum2 != null) {
            id = R.id.join_teacher_name;
            EditText joinTeacherName2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.join_teacher_name);
            if (joinTeacherName2 != null) {
                id = R.id.join_teacher_num;
                EditText joinTeacherNum2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.join_teacher_num);
                if (joinTeacherNum2 != null) {
                    return new ActivityJoinTeachResearchSectionBinding((ConstraintLayout) rootView2, joinSectionNum2, joinTeacherName2, joinTeacherNum2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
