package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityVirtualTeachResearchSectionBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final Spinner spSection;

    private ActivityVirtualTeachResearchSectionBinding(ConstraintLayout rootView2, Spinner spSection2) {
        this.rootView = rootView2;
        this.spSection = spSection2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityVirtualTeachResearchSectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityVirtualTeachResearchSectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_virtual_teach_research_section, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityVirtualTeachResearchSectionBinding bind(View rootView2) {
        Spinner spSection2 = (Spinner) ViewBindings.findChildViewById(rootView2, R.id.sp_section);
        if (spSection2 != null) {
            return new ActivityVirtualTeachResearchSectionBinding((ConstraintLayout) rootView2, spSection2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.sp_section)));
    }
}
