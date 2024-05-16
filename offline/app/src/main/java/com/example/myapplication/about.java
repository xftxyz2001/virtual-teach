package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class about extends AppCompatActivity {
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_about);
        Intent intent = getIntent();
        if (intent != null) {
            this.user_name = intent.getStringExtra("user_name");
        } else {
            this.user_name = "";
        }
    }

    public void back_to_setting(View view) {
        Intent intent = new Intent(this, setting.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void go_to_suggestion(View view) {
        Intent intent = new Intent(this, suggestion.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }
}
