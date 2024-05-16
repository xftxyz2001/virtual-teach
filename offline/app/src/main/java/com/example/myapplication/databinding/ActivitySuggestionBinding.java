package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivitySuggestionBinding implements ViewBinding {
    public final RadioButton baseFunc;
    public final EditText contactInformation;
    public final RadioButton crashFlashback;
    public final RadioButton displayAbnormalities;
    public final RadioButton elseProblem;
    public final EditText quesDescribe;
    public final RadioGroup rgQuesType;
    private final ConstraintLayout rootView;
    public final RadioButton sysInform;

    private ActivitySuggestionBinding(ConstraintLayout rootView2, RadioButton baseFunc2, EditText contactInformation2, RadioButton crashFlashback2, RadioButton displayAbnormalities2, RadioButton elseProblem2, EditText quesDescribe2, RadioGroup rgQuesType2, RadioButton sysInform2) {
        this.rootView = rootView2;
        this.baseFunc = baseFunc2;
        this.contactInformation = contactInformation2;
        this.crashFlashback = crashFlashback2;
        this.displayAbnormalities = displayAbnormalities2;
        this.elseProblem = elseProblem2;
        this.quesDescribe = quesDescribe2;
        this.rgQuesType = rgQuesType2;
        this.sysInform = sysInform2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySuggestionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivitySuggestionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_suggestion, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivitySuggestionBinding bind(View rootView2) {
        View view = rootView2;
        int id = R.id.base_func;
        RadioButton baseFunc2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.base_func);
        if (baseFunc2 != null) {
            id = R.id.contact_information;
            EditText contactInformation2 = (EditText) ViewBindings.findChildViewById(view, R.id.contact_information);
            if (contactInformation2 != null) {
                id = R.id.crash_flashback;
                RadioButton crashFlashback2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.crash_flashback);
                if (crashFlashback2 != null) {
                    id = R.id.display_abnormalities;
                    RadioButton displayAbnormalities2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.display_abnormalities);
                    if (displayAbnormalities2 != null) {
                        id = R.id.else_problem;
                        RadioButton elseProblem2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.else_problem);
                        if (elseProblem2 != null) {
                            id = R.id.ques_describe;
                            EditText quesDescribe2 = (EditText) ViewBindings.findChildViewById(view, R.id.ques_describe);
                            if (quesDescribe2 != null) {
                                id = R.id.rg_ques_type;
                                RadioGroup rgQuesType2 = (RadioGroup) ViewBindings.findChildViewById(view, R.id.rg_ques_type);
                                if (rgQuesType2 != null) {
                                    id = R.id.sys_inform;
                                    RadioButton sysInform2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.sys_inform);
                                    if (sysInform2 != null) {
                                        return new ActivitySuggestionBinding((ConstraintLayout) view, baseFunc2, contactInformation2, crashFlashback2, displayAbnormalities2, elseProblem2, quesDescribe2, rgQuesType2, sysInform2);
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
