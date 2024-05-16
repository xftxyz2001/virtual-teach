package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityHomeworkManagementBinding implements ViewBinding {
    public final ListView lvMyPublish;
    private final ConstraintLayout rootView;

    private ActivityHomeworkManagementBinding(ConstraintLayout rootView2, ListView lvMyPublish2) {
        this.rootView = rootView2;
        this.lvMyPublish = lvMyPublish2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityHomeworkManagementBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityHomeworkManagementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_homework_management, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityHomeworkManagementBinding bind(View rootView2) {
        ListView lvMyPublish2 = (ListView) ViewBindings.findChildViewById(rootView2, R.id.lv_my_publish);
        if (lvMyPublish2 != null) {
            return new ActivityHomeworkManagementBinding((ConstraintLayout) rootView2, lvMyPublish2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.lv_my_publish)));
    }
}
