package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityCreateVirtualTeachResearchSectionBinding implements ViewBinding {
    public final EditText createSectionName;
    public final EditText createTeacherName;
    private final ConstraintLayout rootView;
    public final Spinner selectDepartment;
    public final Spinner selectTeachResearchCourse;

    private ActivityCreateVirtualTeachResearchSectionBinding(ConstraintLayout rootView2, EditText createSectionName2, EditText createTeacherName2, Spinner selectDepartment2, Spinner selectTeachResearchCourse2) {
        this.rootView = rootView2;
        this.createSectionName = createSectionName2;
        this.createTeacherName = createTeacherName2;
        this.selectDepartment = selectDepartment2;
        this.selectTeachResearchCourse = selectTeachResearchCourse2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCreateVirtualTeachResearchSectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityCreateVirtualTeachResearchSectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_create_virtual_teach_research_section, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityCreateVirtualTeachResearchSectionBinding bind(View rootView2) {
        int id = R.id.create_section_name;
        EditText createSectionName2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.create_section_name);
        if (createSectionName2 != null) {
            id = R.id.create_teacher_name;
            EditText createTeacherName2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.create_teacher_name);
            if (createTeacherName2 != null) {
                id = R.id.select_department;
                Spinner selectDepartment2 = (Spinner) ViewBindings.findChildViewById(rootView2, R.id.select_department);
                if (selectDepartment2 != null) {
                    id = R.id.select_teachResearch_course;
                    Spinner selectTeachResearchCourse2 = (Spinner) ViewBindings.findChildViewById(rootView2, R.id.select_teachResearch_course);
                    if (selectTeachResearchCourse2 != null) {
                        return new ActivityCreateVirtualTeachResearchSectionBinding((ConstraintLayout) rootView2, createSectionName2, createTeacherName2, selectDepartment2, selectTeachResearchCourse2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
