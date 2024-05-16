package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class ActivityMeetingReminderBinding implements ViewBinding {
    public final ListView lvMeeting;
    private final ConstraintLayout rootView;

    private ActivityMeetingReminderBinding(ConstraintLayout rootView2, ListView lvMeeting2) {
        this.rootView = rootView2;
        this.lvMeeting = lvMeeting2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMeetingReminderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityMeetingReminderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_meeting_reminder, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMeetingReminderBinding bind(View rootView2) {
        ListView lvMeeting2 = (ListView) ViewBindings.findChildViewById(rootView2, R.id.lv_meeting);
        if (lvMeeting2 != null) {
            return new ActivityMeetingReminderBinding((ConstraintLayout) rootView2, lvMeeting2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.lv_meeting)));
    }
}
