package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class LoginInterfaceBinding implements ViewBinding {
    public final LinearLayout LogIn;
    public final Button forgetPwd;
    public final Button loginButton;
    public final EditText password;
    private final RelativeLayout rootView;
    public final EditText userName;
    public final TextView welcome;

    private LoginInterfaceBinding(RelativeLayout rootView2, LinearLayout LogIn2, Button forgetPwd2, Button loginButton2, EditText password2, EditText userName2, TextView welcome2) {
        this.rootView = rootView2;
        this.LogIn = LogIn2;
        this.forgetPwd = forgetPwd2;
        this.loginButton = loginButton2;
        this.password = password2;
        this.userName = userName2;
        this.welcome = welcome2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LoginInterfaceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static LoginInterfaceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.login_interface, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LoginInterfaceBinding bind(View rootView2) {
        View view = rootView2;
        int id = R.id.LogIn;
        LinearLayout LogIn2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.LogIn);
        if (LogIn2 != null) {
            id = R.id.forget_pwd;
            Button forgetPwd2 = (Button) ViewBindings.findChildViewById(view, R.id.forget_pwd);
            if (forgetPwd2 != null) {
                id = R.id.login_button;
                Button loginButton2 = (Button) ViewBindings.findChildViewById(view, R.id.login_button);
                if (loginButton2 != null) {
                    id = R.id.password;
                    EditText password2 = (EditText) ViewBindings.findChildViewById(view, R.id.password);
                    if (password2 != null) {
                        id = R.id.userName;
                        EditText userName2 = (EditText) ViewBindings.findChildViewById(view, R.id.userName);
                        if (userName2 != null) {
                            id = R.id.welcome;
                            TextView welcome2 = (TextView) ViewBindings.findChildViewById(view, R.id.welcome);
                            if (welcome2 != null) {
                                return new LoginInterfaceBinding((RelativeLayout) view, LogIn2, forgetPwd2, loginButton2, password2, userName2, welcome2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
