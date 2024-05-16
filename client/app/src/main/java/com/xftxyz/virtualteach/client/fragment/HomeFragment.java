package com.xftxyz.virtualteach.client.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.activity.CourseActivity;
import com.xftxyz.virtualteach.client.activity.MeetingActivity;
import com.xftxyz.virtualteach.client.activity.NewsActivity;
import com.xftxyz.virtualteach.client.activity.NotificationActivity;
import com.xftxyz.virtualteach.client.activity.PostActivity;
import com.xftxyz.virtualteach.client.activity.ProfileActivity;
import com.xftxyz.virtualteach.client.activity.SectionActivity;
import com.xftxyz.virtualteach.client.activity.SettingActivity;

/**
 * 首页
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
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initWidgets(inflate);
        initListeners();
        return inflate;
    }

    private void initListeners() {
        btnToNews.setOnClickListener(v -> {
            // 前往新闻公告
            startActivity(new Intent(getActivity(), NewsActivity.class));
        });
        btnToSection.setOnClickListener(v -> {
            // 前往虚拟教研室
            startActivity(new Intent(getActivity(), SectionActivity.class));
        });
        btnToMeeting.setOnClickListener(v -> {
            // 前往会议提醒
            startActivity(new Intent(getActivity(), MeetingActivity.class));
        });
        btnToNotification.setOnClickListener(v -> {
            // 前往系统公告
            startActivity(new Intent(getActivity(), NotificationActivity.class));
        });
        btnToProfile.setOnClickListener(v -> {
            // 前往个人信息
            startActivity(new Intent(getActivity(), ProfileActivity.class));
        });
        btnToMyCourse.setOnClickListener(v -> {
            // 前往我的课程
            startActivity(new Intent(getActivity(), CourseActivity.class));
        });
        btnToMyPost.setOnClickListener(v -> {
            // 前往我的发布
            startActivity(new Intent(getActivity(), PostActivity.class));
        });
        btnToSetting.setOnClickListener(v -> {
            // 前往设置
            startActivity(new Intent(getActivity(), SettingActivity.class));
        });
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