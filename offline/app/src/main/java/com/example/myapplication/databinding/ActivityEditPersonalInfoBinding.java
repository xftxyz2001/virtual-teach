package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityEditPersonalInfoBinding implements ViewBinding {
    public final CardView card;
    public final Button department;
    public final Button editUserTeacherNum;
    public final Button headSculpture;
    public final TextView nickName;
    private final ConstraintLayout rootView;
    public final Button sign;
    public final TextView signInDay;
    public final Button teacherName1;
    public final Button telephoneNumber;

    private ActivityEditPersonalInfoBinding(ConstraintLayout rootView2, CardView card2, Button department2, Button editUserTeacherNum2, Button headSculpture2, TextView nickName2, Button sign2, TextView signInDay2, Button teacherName12, Button telephoneNumber2) {
        this.rootView = rootView2;
        this.card = card2;
        this.department = department2;
        this.editUserTeacherNum = editUserTeacherNum2;
        this.headSculpture = headSculpture2;
        this.nickName = nickName2;
        this.sign = sign2;
        this.signInDay = signInDay2;
        this.teacherName1 = teacherName12;
        this.telephoneNumber = telephoneNumber2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityEditPersonalInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityEditPersonalInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_edit_personal_info, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityEditPersonalInfoBinding bind(View rootView2) {
        View view = rootView2;
        int id = R.id.card;
        CardView card2 = (CardView) ViewBindings.findChildViewById(view, R.id.card);
        if (card2 != null) {
            id = R.id.department;
            Button department2 = (Button) ViewBindings.findChildViewById(view, R.id.department);
            if (department2 != null) {
                id = R.id.edit_user_teacher_num;
                Button editUserTeacherNum2 = (Button) ViewBindings.findChildViewById(view, R.id.edit_user_teacher_num);
                if (editUserTeacherNum2 != null) {
                    id = R.id.head_sculpture;
                    Button headSculpture2 = (Button) ViewBindings.findChildViewById(view, R.id.head_sculpture);
                    if (headSculpture2 != null) {
                        id = R.id.nick_name;
                        TextView nickName2 = (TextView) ViewBindings.findChildViewById(view, R.id.nick_name);
                        if (nickName2 != null) {
                            id = R.id.sign;
                            Button sign2 = (Button) ViewBindings.findChildViewById(view, R.id.sign);
                            if (sign2 != null) {
                                id = R.id.sign_in_day;
                                TextView signInDay2 = (TextView) ViewBindings.findChildViewById(view, R.id.sign_in_day);
                                if (signInDay2 != null) {
                                    id = R.id.teacher_name_1;
                                    Button teacherName12 = (Button) ViewBindings.findChildViewById(view, R.id.teacher_name_1);
                                    if (teacherName12 != null) {
                                        id = R.id.telephone_number;
                                        Button telephoneNumber2 = (Button) ViewBindings.findChildViewById(view, R.id.telephone_number);
                                        if (telephoneNumber2 != null) {
                                            return new ActivityEditPersonalInfoBinding((ConstraintLayout) view, card2, department2, editUserTeacherNum2, headSculpture2, nickName2, sign2, signInDay2, teacherName12, telephoneNumber2);
                                        }
                                    }
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
