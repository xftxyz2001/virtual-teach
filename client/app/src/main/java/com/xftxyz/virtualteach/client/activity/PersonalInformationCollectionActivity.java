package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.xftxyz.virtualteach.client.R;

public class PersonalInformationCollectionActivity extends AppCompatActivity {

    private TextView tvPersonalInformationCollectionChecklist;
    private String personal_information = "1.基本信息：\n姓名\n性别\n教职工号\n2.联系信息：\n电子邮件地址\n联系电话\n3.账号信息：\n用户名\n密码\n4.教育与职业信息：\n职业信息（职位、所属教研室）\n5.兴趣爱好：\n研究方向\n参与的学术活动\n6.设备信息：\nIP地址\n设备型号\n操作系统类型和版本\n浏览器类型和版本\n7.其他信息：\n社交媒体账号（可选）\n用户生成内容（上传的研究资料、论文等）\n用户行为数据（登录记录、操作记录等）\n以上个人信息收集清单旨在为虚拟教研室系统提供必要的功能和服务，并确保用户参与学术交流的顺畅进行。在收集和处理个人信息时，系统应遵守相关的隐私政策和法律法规，保护用户的隐私和个人信息安全。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_information_collection);

        initWidgets();
    }

    private void initWidgets() {
        tvPersonalInformationCollectionChecklist = findViewById(R.id.tv_personal_information_collection_checklist);
        tvPersonalInformationCollectionChecklist.setText(personal_information);
    }
}