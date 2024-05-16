package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityMainBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvWelcome;

    private ActivityMainBinding(ConstraintLayout rootView2, TextView tvWelcome2) {
        this.rootView = rootView2;
        this.tvWelcome = tvWelcome2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_main, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMainBinding bind(View rootView2) {
        TextView tvWelcome2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.tv_welcome);
        if (tvWelcome2 != null) {
            return new ActivityMainBinding((ConstraintLayout) rootView2, tvWelcome2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.tv_welcome)));
    }
}
