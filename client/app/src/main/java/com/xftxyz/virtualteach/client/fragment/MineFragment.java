package com.xftxyz.virtualteach.client.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.xftxyz.virtualteach.client.R;

/**
 * 我的
 */
public class MineFragment extends Fragment {

    private Button btnToProfile;
    private Button btnToMyCourse;
    private Button btnToMyPost;
    private Button btnToSetting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_mine, container, false);
        initWidgets(inflate);
        initListeners();
        return inflate;
    }

    private void initListeners() {
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
        btnToProfile = view.findViewById(R.id.btn_mine_to_profile);
        btnToMyCourse = view.findViewById(R.id.btn_mine_to_my_course);
        btnToMyPost = view.findViewById(R.id.btn_mine_to_my_post);
        btnToSetting = view.findViewById(R.id.btn_mine_to_setting);
    }
}