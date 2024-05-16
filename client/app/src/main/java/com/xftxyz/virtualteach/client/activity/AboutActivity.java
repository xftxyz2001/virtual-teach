package com.xftxyz.virtualteach.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.xftxyz.virtualteach.client.R;

public class AboutActivity extends AppCompatActivity {

    private Button btnAboutToSuggestion;
    private TextView tvAboutLocalVersion;
    private TextView tvAboutNewVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);

        initWidgets();
        initListeners();
    }

    private void initListeners() {
        btnAboutToSuggestion.setOnClickListener(v -> {
            startActivity(new Intent(AboutActivity.this, SuggestionActivity.class));
        });
    }

    private void initWidgets() {
        btnAboutToSuggestion = findViewById(R.id.btn_about_to_suggestion);
        tvAboutLocalVersion = findViewById(R.id.tv_about_local_version);
        tvAboutNewVersion = findViewById(R.id.tv_about_new_version);
    }
}