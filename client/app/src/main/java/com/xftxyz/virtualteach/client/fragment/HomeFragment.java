package com.xftxyz.virtualteach.client.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.xftxyz.virtualteach.client.R;

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
        });
        btnToSection.setOnClickListener(v -> {
            // 前往虚拟教研室
        });
        btnToMeeting.setOnClickListener(v -> {
            // 前往会议提醒
        });
        btnToNotification.setOnClickListener(v -> {
            // 前往系统公告
        });
        btnToProfile.setOnClickListener(v -> {
            // 前往个人信息
        });
        btnToMyCourse.setOnClickListener(v -> {
            // 前往我的课程
        });
        btnToMyPost.setOnClickListener(v -> {
            // 前往我的发布
        });
        btnToSetting.setOnClickListener(v -> {
            // 前往设置
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