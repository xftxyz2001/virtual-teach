package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityForgetPwdBinding implements ViewBinding {
    public final LinearLayout forgetPwdPage;
    public final TextView forgetText;
    public final Button nextStep;
    private final ConstraintLayout rootView;
    public final Button sendVerifyCode;
    public final EditText telephoneNum;
    public final EditText userName;
    public final EditText verifyCode;

    private ActivityForgetPwdBinding(ConstraintLayout rootView2, LinearLayout forgetPwdPage2, TextView forgetText2, Button nextStep2, Button sendVerifyCode2, EditText telephoneNum2, EditText userName2, EditText verifyCode2) {
        this.rootView = rootView2;
        this.forgetPwdPage = forgetPwdPage2;
        this.forgetText = forgetText2;
        this.nextStep = nextStep2;
        this.sendVerifyCode = sendVerifyCode2;
        this.telephoneNum = telephoneNum2;
        this.userName = userName2;
        this.verifyCode = verifyCode2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityForgetPwdBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityForgetPwdBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_forget_pwd, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityForgetPwdBinding bind(View rootView2) {
        View view = rootView2;
        int id = R.id.forget_pwd_page;
        LinearLayout forgetPwdPage2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.forget_pwd_page);
        if (forgetPwdPage2 != null) {
            id = R.id.forget_text;
            TextView forgetText2 = (TextView) ViewBindings.findChildViewById(view, R.id.forget_text);
            if (forgetText2 != null) {
                id = R.id.next_step;
                Button nextStep2 = (Button) ViewBindings.findChildViewById(view, R.id.next_step);
                if (nextStep2 != null) {
                    id = R.id.send_Verify_code;
                    Button sendVerifyCode2 = (Button) ViewBindings.findChildViewById(view, R.id.send_Verify_code);
                    if (sendVerifyCode2 != null) {
                        id = R.id.telephone_num;
                        EditText telephoneNum2 = (EditText) ViewBindings.findChildViewById(view, R.id.telephone_num);
                        if (telephoneNum2 != null) {
                            id = R.id.userName;
                            EditText userName2 = (EditText) ViewBindings.findChildViewById(view, R.id.userName);
                            if (userName2 != null) {
                                id = R.id.verify_code;
                                EditText verifyCode2 = (EditText) ViewBindings.findChildViewById(view, R.id.verify_code);
                                if (verifyCode2 != null) {
                                    return new ActivityForgetPwdBinding((ConstraintLayout) view, forgetPwdPage2, forgetText2, nextStep2, sendVerifyCode2, telephoneNum2, userName2, verifyCode2);
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
