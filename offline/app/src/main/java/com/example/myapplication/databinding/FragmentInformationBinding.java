package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;

public final class FragmentInformationBinding implements ViewBinding {
    public final Button addressBook;
    public final Button meetingReminder;
    private final ConstraintLayout rootView;
    public final Button systemNotifications;
    public final Button virtualTeachResearchSection;

    private FragmentInformationBinding(ConstraintLayout rootView2, Button addressBook2, Button meetingReminder2, Button systemNotifications2, Button virtualTeachResearchSection2) {
        this.rootView = rootView2;
        this.addressBook = addressBook2;
        this.meetingReminder = meetingReminder2;
        this.systemNotifications = systemNotifications2;
        this.virtualTeachResearchSection = virtualTeachResearchSection2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentInformationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static FragmentInformationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_information, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentInformationBinding bind(View rootView2) {
        int id = R.id.address_book;
        Button addressBook2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.address_book);
        if (addressBook2 != null) {
            id = R.id.meeting_reminder;
            Button meetingReminder2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.meeting_reminder);
            if (meetingReminder2 != null) {
                id = R.id.system_notifications;
                Button systemNotifications2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.system_notifications);
                if (systemNotifications2 != null) {
                    id = R.id.virtual_teachResearch_section;
                    Button virtualTeachResearchSection2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.virtual_teachResearch_section);
                    if (virtualTeachResearchSection2 != null) {
                        return new FragmentInformationBinding((ConstraintLayout) rootView2, addressBook2, meetingReminder2, systemNotifications2, virtualTeachResearchSection2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
