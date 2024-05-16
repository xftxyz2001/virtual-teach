package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityMyCreateSectionBinding implements ViewBinding {
    public final ListView lvMyCreateSection;
    private final ConstraintLayout rootView;

    private ActivityMyCreateSectionBinding(ConstraintLayout rootView2, ListView lvMyCreateSection2) {
        this.rootView = rootView2;
        this.lvMyCreateSection = lvMyCreateSection2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMyCreateSectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityMyCreateSectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_my_create_section, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMyCreateSectionBinding bind(View rootView2) {
        ListView lvMyCreateSection2 = (ListView) ViewBindings.findChildViewById(rootView2, R.id.lv_my_create_section);
        if (lvMyCreateSection2 != null) {
            return new ActivityMyCreateSectionBinding((ConstraintLayout) rootView2, lvMyCreateSection2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.lv_my_create_section)));
    }
}
