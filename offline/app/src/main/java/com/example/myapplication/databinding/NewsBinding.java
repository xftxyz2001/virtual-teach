package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class NewsBinding implements ViewBinding {
    public final TextView newDate;
    public final TextView newsTopic;
    private final LinearLayout rootView;

    private NewsBinding(LinearLayout rootView2, TextView newDate2, TextView newsTopic2) {
        this.rootView = rootView2;
        this.newDate = newDate2;
        this.newsTopic = newsTopic2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NewsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static NewsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.news, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static NewsBinding bind(View rootView2) {
        int id = R.id.new_date;
        TextView newDate2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.new_date);
        if (newDate2 != null) {
            id = R.id.news_topic;
            TextView newsTopic2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.news_topic);
            if (newsTopic2 != null) {
                return new NewsBinding((LinearLayout) rootView2, newDate2, newsTopic2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
