package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class SystemInformationBinding implements ViewBinding {
    public final TextView informationTopic;
    public final TextView releaseTime;
    private final LinearLayout rootView;
    public final TextView systemInformationType;

    private SystemInformationBinding(LinearLayout rootView2, TextView informationTopic2, TextView releaseTime2, TextView systemInformationType2) {
        this.rootView = rootView2;
        this.informationTopic = informationTopic2;
        this.releaseTime = releaseTime2;
        this.systemInformationType = systemInformationType2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SystemInformationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static SystemInformationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.system_information, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static SystemInformationBinding bind(View rootView2) {
        int id = R.id.information_topic;
        TextView informationTopic2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.information_topic);
        if (informationTopic2 != null) {
            id = R.id.release_time;
            TextView releaseTime2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.release_time);
            if (releaseTime2 != null) {
                id = R.id.system_information_type;
                TextView systemInformationType2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.system_information_type);
                if (systemInformationType2 != null) {
                    return new SystemInformationBinding((LinearLayout) rootView2, informationTopic2, releaseTime2, systemInformationType2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
