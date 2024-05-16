package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public final class ActivityMainPageBinding implements ViewBinding {
    public final ConstraintLayout container;
    public final BottomNavigationView navView;
    private final ConstraintLayout rootView;

    private ActivityMainPageBinding(ConstraintLayout rootView2, ConstraintLayout container2, BottomNavigationView navView2) {
        this.rootView = rootView2;
        this.container = container2;
        this.navView = navView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityMainPageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_main_page, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMainPageBinding bind(View rootView2) {
        ConstraintLayout container2 = (ConstraintLayout) rootView2;
        BottomNavigationView navView2 = (BottomNavigationView) ViewBindings.findChildViewById(rootView2, R.id.nav_view);
        if (navView2 != null) {
            return new ActivityMainPageBinding((ConstraintLayout) rootView2, container2, navView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.nav_view)));
    }
}
