package com.xftxyz.virtualteach.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class SettingActivity extends AppCompatActivity {

    private Button btnAccountManagement;
    private Switch switchReceivePushNotifications;
    private Switch switchNotificationDetails;
    private Button btnPrivacyPolicy;
    private Button btnUserAgreement;
    private Button btnPersonalInformationCollectionChecklist;
    private Button btnAbout;
    private Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);

        initWidgets();
        initListeners();
    }

    private void initListeners() {
        btnAccountManagement.setOnClickListener(v -> {
            startActivity(new Intent(SettingActivity.this, ProfileActivity.class));
        });
        switchReceivePushNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {

        });
        switchNotificationDetails.setOnCheckedChangeListener((buttonView, isChecked) -> {

        });
        btnPrivacyPolicy.setOnClickListener(v -> {
            startActivity(new Intent(SettingActivity.this, PrivacyPolicyActivity.class));
        });
        btnUserAgreement.setOnClickListener(v -> {
            startActivity(new Intent(SettingActivity.this, UserAgreementActivity.class));
        });
        btnPersonalInformationCollectionChecklist.setOnClickListener(v -> {
            startActivity(new Intent(SettingActivity.this, PersonalInformationCollectionActivity.class));
        });
        btnAbout.setOnClickListener(v -> {
            startActivity(new Intent(SettingActivity.this, AboutActivity.class));
        });
        btnLogout.setOnClickListener(v -> {
            startActivity(new Intent(SettingActivity.this, LoginActivity.class));
        });
    }

    private void initWidgets() {
        btnAccountManagement = findViewById(R.id.btn_setting_account_management);
        switchReceivePushNotifications = findViewById(R.id.switch_setting_receive_push_notifications);
        switchNotificationDetails = findViewById(R.id.switch_setting_notification_details);
        btnPrivacyPolicy = findViewById(R.id.btn_setting_privacy_policy);
        btnUserAgreement = findViewById(R.id.btn_setting_user_agreement);
        btnPersonalInformationCollectionChecklist = findViewById(R.id.btn_setting_personal_information_collection_checklist);
        btnAbout = findViewById(R.id.btn_setting_about);
        btnLogout = findViewById(R.id.btn_setting_logout);
    }
}