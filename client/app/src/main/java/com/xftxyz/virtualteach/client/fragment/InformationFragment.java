package com.xftxyz.virtualteach.client.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.xftxyz.virtualteach.client.R;

/**
 * 信息
 */
public class InformationFragment extends Fragment {

    private Button btnToNews;
    private Button btnToSection;
    private Button btnToMeeting;
    private Button btnToNotification;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_information, container, false);
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
    }

    private void initWidgets(View view) {
        btnToNews = view.findViewById(R.id.btn_info_to_news);
        btnToSection = view.findViewById(R.id.btn_info_to_section);
        btnToMeeting = view.findViewById(R.id.btn_info_to_meeting);
        btnToNotification = view.findViewById(R.id.btn_info_to_notification);
    }
}