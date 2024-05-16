package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.example.myapplication.R;

public final class RecommendedContentBinding implements ViewBinding {
    public final RadioGroup point;
    public final ViewPager recommendContent;
    private final RelativeLayout rootView;

    private RecommendedContentBinding(RelativeLayout rootView2, RadioGroup point2, ViewPager recommendContent2) {
        this.rootView = rootView2;
        this.point = point2;
        this.recommendContent = recommendContent2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RecommendedContentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static RecommendedContentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.recommended_content, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static RecommendedContentBinding bind(View rootView2) {
        int id = R.id.point;
        RadioGroup point2 = (RadioGroup) ViewBindings.findChildViewById(rootView2, R.id.point);
        if (point2 != null) {
            id = R.id.recommend_content;
            ViewPager recommendContent2 = (ViewPager) ViewBindings.findChildViewById(rootView2, R.id.recommend_content);
            if (recommendContent2 != null) {
                return new RecommendedContentBinding((RelativeLayout) rootView2, point2, recommendContent2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
