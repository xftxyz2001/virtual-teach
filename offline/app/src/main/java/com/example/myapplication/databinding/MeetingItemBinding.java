package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class MeetingItemBinding implements ViewBinding {
    public final Button btnJoin;
    public final LinearLayout meeting;
    public final TextView meetingNum;
    public final TextView meetingStartTime;
    public final TextView meetingTopic;
    private final LinearLayout rootView;

    private MeetingItemBinding(LinearLayout rootView2, Button btnJoin2, LinearLayout meeting2, TextView meetingNum2, TextView meetingStartTime2, TextView meetingTopic2) {
        this.rootView = rootView2;
        this.btnJoin = btnJoin2;
        this.meeting = meeting2;
        this.meetingNum = meetingNum2;
        this.meetingStartTime = meetingStartTime2;
        this.meetingTopic = meetingTopic2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MeetingItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static MeetingItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.meeting_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static MeetingItemBinding bind(View rootView2) {
        int id = R.id.btn_join;
        Button btnJoin2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.btn_join);
        if (btnJoin2 != null) {
            id = R.id.meeting;
            LinearLayout meeting2 = (LinearLayout) ViewBindings.findChildViewById(rootView2, R.id.meeting);
            if (meeting2 != null) {
                id = R.id.meeting_num;
                TextView meetingNum2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.meeting_num);
                if (meetingNum2 != null) {
                    id = R.id.meeting_startTime;
                    TextView meetingStartTime2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.meeting_startTime);
                    if (meetingStartTime2 != null) {
                        id = R.id.meeting_topic;
                        TextView meetingTopic2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.meeting_topic);
                        if (meetingTopic2 != null) {
                            return new MeetingItemBinding((LinearLayout) rootView2, btnJoin2, meeting2, meetingNum2, meetingStartTime2, meetingTopic2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
