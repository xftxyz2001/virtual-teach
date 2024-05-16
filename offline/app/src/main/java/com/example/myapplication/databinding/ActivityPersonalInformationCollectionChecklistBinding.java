package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityPersonalInformationCollectionChecklistBinding implements ViewBinding {
    public final TextView personalInformation;
    private final ConstraintLayout rootView;

    private ActivityPersonalInformationCollectionChecklistBinding(ConstraintLayout rootView2, TextView personalInformation2) {
        this.rootView = rootView2;
        this.personalInformation = personalInformation2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPersonalInformationCollectionChecklistBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityPersonalInformationCollectionChecklistBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_personal_information_collection_checklist, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityPersonalInformationCollectionChecklistBinding bind(View rootView2) {
        TextView personalInformation2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.personal_information);
        if (personalInformation2 != null) {
            return new ActivityPersonalInformationCollectionChecklistBinding((ConstraintLayout) rootView2, personalInformation2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.personal_information)));
    }
}
