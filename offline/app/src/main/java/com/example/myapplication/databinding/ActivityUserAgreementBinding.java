package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityUserAgreementBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView userAgreement;

    private ActivityUserAgreementBinding(ConstraintLayout rootView2, TextView userAgreement2) {
        this.rootView = rootView2;
        this.userAgreement = userAgreement2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUserAgreementBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityUserAgreementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_user_agreement, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityUserAgreementBinding bind(View rootView2) {
        TextView userAgreement2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.user_agreement);
        if (userAgreement2 != null) {
            return new ActivityUserAgreementBinding((ConstraintLayout) rootView2, userAgreement2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.user_agreement)));
    }
}
