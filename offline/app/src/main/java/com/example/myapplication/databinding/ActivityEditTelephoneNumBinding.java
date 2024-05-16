package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityEditTelephoneNumBinding implements ViewBinding {
    public final EditText newTelephoneNum;
    private final ConstraintLayout rootView;
    public final EditText verify;

    private ActivityEditTelephoneNumBinding(ConstraintLayout rootView2, EditText newTelephoneNum2, EditText verify2) {
        this.rootView = rootView2;
        this.newTelephoneNum = newTelephoneNum2;
        this.verify = verify2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityEditTelephoneNumBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityEditTelephoneNumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_edit_telephone_num, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityEditTelephoneNumBinding bind(View rootView2) {
        int id = R.id.new_telephone_num;
        EditText newTelephoneNum2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.new_telephone_num);
        if (newTelephoneNum2 != null) {
            id = R.id.verify;
            EditText verify2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.verify);
            if (verify2 != null) {
                return new ActivityEditTelephoneNumBinding((ConstraintLayout) rootView2, newTelephoneNum2, verify2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
