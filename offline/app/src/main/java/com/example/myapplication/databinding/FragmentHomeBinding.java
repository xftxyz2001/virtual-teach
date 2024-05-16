package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class FragmentHomeBinding implements ViewBinding {
    public final Button goToMeeting;
    public final Button goToMyCourse;
    public final Button goToMyOutput;
    public final Button goToNews;
    public final Button goToSection;
    public final Button goToSelf;
    public final Button goToSetting;
    public final Button goToSystem;
    private final ConstraintLayout rootView;

    private FragmentHomeBinding(ConstraintLayout rootView2, Button goToMeeting2, Button goToMyCourse2, Button goToMyOutput2, Button goToNews2, Button goToSection2, Button goToSelf2, Button goToSetting2, Button goToSystem2) {
        this.rootView = rootView2;
        this.goToMeeting = goToMeeting2;
        this.goToMyCourse = goToMyCourse2;
        this.goToMyOutput = goToMyOutput2;
        this.goToNews = goToNews2;
        this.goToSection = goToSection2;
        this.goToSelf = goToSelf2;
        this.goToSetting = goToSetting2;
        this.goToSystem = goToSystem2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static FragmentHomeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_home, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentHomeBinding bind(View rootView2) {
        View view = rootView2;
        int id = R.id.go_to_meeting;
        Button goToMeeting2 = (Button) ViewBindings.findChildViewById(view, R.id.go_to_meeting);
        if (goToMeeting2 != null) {
            id = R.id.go_to_myCourse;
            Button goToMyCourse2 = (Button) ViewBindings.findChildViewById(view, R.id.go_to_myCourse);
            if (goToMyCourse2 != null) {
                id = R.id.go_to_myOutput;
                Button goToMyOutput2 = (Button) ViewBindings.findChildViewById(view, R.id.go_to_myOutput);
                if (goToMyOutput2 != null) {
                    id = R.id.go_to_news;
                    Button goToNews2 = (Button) ViewBindings.findChildViewById(view, R.id.go_to_news);
                    if (goToNews2 != null) {
                        id = R.id.go_to_section;
                        Button goToSection2 = (Button) ViewBindings.findChildViewById(view, R.id.go_to_section);
                        if (goToSection2 != null) {
                            id = R.id.go_to_self;
                            Button goToSelf2 = (Button) ViewBindings.findChildViewById(view, R.id.go_to_self);
                            if (goToSelf2 != null) {
                                id = R.id.go_to_setting;
                                Button goToSetting2 = (Button) ViewBindings.findChildViewById(view, R.id.go_to_setting);
                                if (goToSetting2 != null) {
                                    id = R.id.go_to_system;
                                    Button goToSystem2 = (Button) ViewBindings.findChildViewById(view, R.id.go_to_system);
                                    if (goToSystem2 != null) {
                                        return new FragmentHomeBinding((ConstraintLayout) view, goToMeeting2, goToMyCourse2, goToMyOutput2, goToNews2, goToSection2, goToSelf2, goToSetting2, goToSystem2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
