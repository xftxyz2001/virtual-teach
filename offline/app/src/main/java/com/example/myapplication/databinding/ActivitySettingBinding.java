package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.myapplication.R;

public final class ActivitySettingBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ActivitySettingBinding(ConstraintLayout rootView2) {
        this.rootView = rootView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySettingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivitySettingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_setting, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivitySettingBinding bind(View rootView2) {
        if (rootView2 != null) {
            return new ActivitySettingBinding((ConstraintLayout) rootView2);
        }
        throw new NullPointerException("rootView");
    }
}
