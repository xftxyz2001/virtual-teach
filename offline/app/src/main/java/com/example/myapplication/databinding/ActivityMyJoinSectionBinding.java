package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityMyJoinSectionBinding implements ViewBinding {
    public final ListView lvMyJoinSection;
    private final ConstraintLayout rootView;

    private ActivityMyJoinSectionBinding(ConstraintLayout rootView2, ListView lvMyJoinSection2) {
        this.rootView = rootView2;
        this.lvMyJoinSection = lvMyJoinSection2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMyJoinSectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityMyJoinSectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_my_join_section, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMyJoinSectionBinding bind(View rootView2) {
        ListView lvMyJoinSection2 = (ListView) ViewBindings.findChildViewById(rootView2, R.id.lv_my_join_section);
        if (lvMyJoinSection2 != null) {
            return new ActivityMyJoinSectionBinding((ConstraintLayout) rootView2, lvMyJoinSection2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.lv_my_join_section)));
    }
}
