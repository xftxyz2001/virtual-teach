package com.xftxyz.virtualteach.client.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.xftxyz.virtualteach.client.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private Button btnToNews;
    private Button btnToSection;
    private Button btnToMeeting;
    private Button btnToNotification;
    private Button btnToProfile;
    private Button btnToMyCourse;
    private Button btnToMyPost;
    private Button btnToSetting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initWidgets(view);
        return view;
    }

    private void initWidgets(View view) {
        btnToNews = view.findViewById(R.id.btn_home_to_news);
        btnToSection = view.findViewById(R.id.btn_home_to_section);
        btnToMeeting = view.findViewById(R.id.btn_home_to_meeting);
        btnToNotification = view.findViewById(R.id.btn_home_to_notification);
        btnToProfile = view.findViewById(R.id.btn_home_to_profile);
        btnToMyCourse = view.findViewById(R.id.btn_home_to_my_course);
        btnToMyPost = view.findViewById(R.id.btn_home_to_my_post);
        btnToSetting = view.findViewById(R.id.btn_home_to_setting);
    }
}