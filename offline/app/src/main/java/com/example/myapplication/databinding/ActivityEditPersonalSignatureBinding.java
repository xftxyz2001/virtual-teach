package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityEditPersonalSignatureBinding implements ViewBinding {
    public final EditText edPersonalSign;
    private final ConstraintLayout rootView;

    private ActivityEditPersonalSignatureBinding(ConstraintLayout rootView2, EditText edPersonalSign2) {
        this.rootView = rootView2;
        this.edPersonalSign = edPersonalSign2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityEditPersonalSignatureBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityEditPersonalSignatureBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_edit_personal_signature, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityEditPersonalSignatureBinding bind(View rootView2) {
        EditText edPersonalSign2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.ed_personal_sign);
        if (edPersonalSign2 != null) {
            return new ActivityEditPersonalSignatureBinding((ConstraintLayout) rootView2, edPersonalSign2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.ed_personal_sign)));
    }
}
