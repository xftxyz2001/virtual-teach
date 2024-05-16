package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityResetPwdBinding implements ViewBinding {
    public final Button cancel;
    public final Button confirmModify;
    public final EditText newPwd;
    public final EditText newPwdConfirm;
    public final LinearLayout resetPwd;
    private final ConstraintLayout rootView;

    private ActivityResetPwdBinding(ConstraintLayout rootView2, Button cancel2, Button confirmModify2, EditText newPwd2, EditText newPwdConfirm2, LinearLayout resetPwd2) {
        this.rootView = rootView2;
        this.cancel = cancel2;
        this.confirmModify = confirmModify2;
        this.newPwd = newPwd2;
        this.newPwdConfirm = newPwdConfirm2;
        this.resetPwd = resetPwd2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityResetPwdBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityResetPwdBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_reset_pwd, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityResetPwdBinding bind(View rootView2) {
        int id = R.id.cancel;
        Button cancel2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.cancel);
        if (cancel2 != null) {
            id = R.id.confirm_modify;
            Button confirmModify2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.confirm_modify);
            if (confirmModify2 != null) {
                id = R.id.new_pwd;
                EditText newPwd2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.new_pwd);
                if (newPwd2 != null) {
                    id = R.id.new_pwd_confirm;
                    EditText newPwdConfirm2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.new_pwd_confirm);
                    if (newPwdConfirm2 != null) {
                        id = R.id.reset_pwd;
                        LinearLayout resetPwd2 = (LinearLayout) ViewBindings.findChildViewById(rootView2, R.id.reset_pwd);
                        if (resetPwd2 != null) {
                            return new ActivityResetPwdBinding((ConstraintLayout) rootView2, cancel2, confirmModify2, newPwd2, newPwdConfirm2, resetPwd2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
