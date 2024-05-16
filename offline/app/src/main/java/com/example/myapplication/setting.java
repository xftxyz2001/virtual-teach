package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class setting extends AppCompatActivity {
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_setting);
        Intent intent = getIntent();
        if (intent != null) {
            this.user_name = intent.getStringExtra("user_name");
        } else {
            this.user_name = "";
        }
    }

    public void account_management(View view) {
        Intent intent = new Intent(this, editPersonalInfo.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void exit_logIn(View view) {
        startActivity(new Intent(this, logIn.class));
    }

    public void go_to_about(View view) {
        Intent intent = new Intent(this, about.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void go_to_privacy_policy(View view) {
        Intent intent = new Intent(this, privacy_policy.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void go_to_user_agreement(View view) {
        Intent intent = new Intent(this, user_agreement.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void go_to_personal_information(View view) {
        Intent intent = new Intent(this, personal_information_collection_checklist.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void back_to_mine(View view) {
        Intent intent = new Intent();
        intent.setClass(this, Main_Page.class);
        Bundle bundle = new Bundle();
        bundle.putString("user_name", this.user_name);
        bundle.putInt("bid", 2);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
