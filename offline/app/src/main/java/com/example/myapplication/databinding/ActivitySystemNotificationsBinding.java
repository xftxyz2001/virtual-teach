package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivitySystemNotificationsBinding implements ViewBinding {
    public final ListView lvSystemNotification;
    private final ConstraintLayout rootView;

    private ActivitySystemNotificationsBinding(ConstraintLayout rootView2, ListView lvSystemNotification2) {
        this.rootView = rootView2;
        this.lvSystemNotification = lvSystemNotification2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySystemNotificationsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivitySystemNotificationsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_system_notifications, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivitySystemNotificationsBinding bind(View rootView2) {
        ListView lvSystemNotification2 = (ListView) ViewBindings.findChildViewById(rootView2, R.id.lv_system_notification);
        if (lvSystemNotification2 != null) {
            return new ActivitySystemNotificationsBinding((ConstraintLayout) rootView2, lvSystemNotification2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.lv_system_notification)));
    }
}
