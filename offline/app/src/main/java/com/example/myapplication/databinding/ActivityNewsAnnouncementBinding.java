package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityNewsAnnouncementBinding implements ViewBinding {
    public final ListView lvNews;
    private final ConstraintLayout rootView;

    private ActivityNewsAnnouncementBinding(ConstraintLayout rootView2, ListView lvNews2) {
        this.rootView = rootView2;
        this.lvNews = lvNews2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNewsAnnouncementBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityNewsAnnouncementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_news_announcement, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityNewsAnnouncementBinding bind(View rootView2) {
        ListView lvNews2 = (ListView) ViewBindings.findChildViewById(rootView2, R.id.lv_news);
        if (lvNews2 != null) {
            return new ActivityNewsAnnouncementBinding((ConstraintLayout) rootView2, lvNews2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.lv_news)));
    }
}
