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

public final class ActivityRegisterBinding implements ViewBinding {
    public final EditText inputTeacherNum;
    public final EditText name;
    private final ConstraintLayout rootView;
    public final Spinner selectDepartment;

    private ActivityRegisterBinding(ConstraintLayout rootView2, EditText inputTeacherNum2, EditText name2, Spinner selectDepartment2) {
        this.rootView = rootView2;
        this.inputTeacherNum = inputTeacherNum2;
        this.name = name2;
        this.selectDepartment = selectDepartment2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRegisterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityRegisterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_register, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityRegisterBinding bind(View rootView2) {
        int id = R.id.input_teacher_num;
        EditText inputTeacherNum2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.input_teacher_num);
        if (inputTeacherNum2 != null) {
            id = R.id.name;
            EditText name2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.name);
            if (name2 != null) {
                id = R.id.select_department;
                Spinner selectDepartment2 = (Spinner) ViewBindings.findChildViewById(rootView2, R.id.select_department);
                if (selectDepartment2 != null) {
                    return new ActivityRegisterBinding((ConstraintLayout) rootView2, inputTeacherNum2, name2, selectDepartment2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
