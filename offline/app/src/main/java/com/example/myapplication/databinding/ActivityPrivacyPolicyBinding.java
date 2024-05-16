package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.myapplication.R;

public final class ActivityPrivacyPolicyBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ActivityPrivacyPolicyBinding(ConstraintLayout rootView2) {
        this.rootView = rootView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPrivacyPolicyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityPrivacyPolicyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_privacy_policy, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityPrivacyPolicyBinding bind(View rootView2) {
        if (rootView2 != null) {
            return new ActivityPrivacyPolicyBinding((ConstraintLayout) rootView2);
        }
        throw new NullPointerException("rootView");
    }
}
