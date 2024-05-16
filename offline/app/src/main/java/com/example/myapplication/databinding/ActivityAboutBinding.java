package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityAboutBinding implements ViewBinding {
    public final TextView localVersion;
    public final TextView newLocalVersion;
    private final ConstraintLayout rootView;

    private ActivityAboutBinding(ConstraintLayout rootView2, TextView localVersion2, TextView newLocalVersion2) {
        this.rootView = rootView2;
        this.localVersion = localVersion2;
        this.newLocalVersion = newLocalVersion2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAboutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityAboutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_about, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityAboutBinding bind(View rootView2) {
        int id = R.id.local_version;
        TextView localVersion2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.local_version);
        if (localVersion2 != null) {
            id = R.id.new_local_version;
            TextView newLocalVersion2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.new_local_version);
            if (newLocalVersion2 != null) {
                return new ActivityAboutBinding((ConstraintLayout) rootView2, localVersion2, newLocalVersion2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
