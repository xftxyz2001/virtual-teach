package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityCreateUserBinding implements ViewBinding {
    public final EditText createPwd;
    public final EditText createPwdVerify;
    public final EditText createUserNickName;
    public final TextView forgetText;
    public final EditText inputTelephoneNum;
    private final ConstraintLayout rootView;

    private ActivityCreateUserBinding(ConstraintLayout rootView2, EditText createPwd2, EditText createPwdVerify2, EditText createUserNickName2, TextView forgetText2, EditText inputTelephoneNum2) {
        this.rootView = rootView2;
        this.createPwd = createPwd2;
        this.createPwdVerify = createPwdVerify2;
        this.createUserNickName = createUserNickName2;
        this.forgetText = forgetText2;
        this.inputTelephoneNum = inputTelephoneNum2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCreateUserBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityCreateUserBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_create_user, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityCreateUserBinding bind(View rootView2) {
        int id = R.id.create_pwd;
        EditText createPwd2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.create_pwd);
        if (createPwd2 != null) {
            id = R.id.create_pwd_verify;
            EditText createPwdVerify2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.create_pwd_verify);
            if (createPwdVerify2 != null) {
                id = R.id.create_user_nick_name;
                EditText createUserNickName2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.create_user_nick_name);
                if (createUserNickName2 != null) {
                    id = R.id.forget_text;
                    TextView forgetText2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.forget_text);
                    if (forgetText2 != null) {
                        id = R.id.input_telephoneNum;
                        EditText inputTelephoneNum2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.input_telephoneNum);
                        if (inputTelephoneNum2 != null) {
                            return new ActivityCreateUserBinding((ConstraintLayout) rootView2, createPwd2, createPwdVerify2, createUserNickName2, forgetText2, inputTelephoneNum2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
