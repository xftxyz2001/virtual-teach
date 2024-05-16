package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.example.myapplication.R;

public final class SpinnerItemBinding implements ViewBinding {
    private final LinearLayout rootView;

    private SpinnerItemBinding(LinearLayout rootView2) {
        this.rootView = rootView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SpinnerItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static SpinnerItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.spinner_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static SpinnerItemBinding bind(View rootView2) {
        if (rootView2 != null) {
            return new SpinnerItemBinding((LinearLayout) rootView2);
        }
        throw new NullPointerException("rootView");
    }
}
