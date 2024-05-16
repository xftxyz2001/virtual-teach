package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class SectionActivity extends AppCompatActivity {

    private Spinner spSection;
    private Button btnSectionJoined;
    private Button btnSectionCreated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_section);

        initWidgets();
    }

    private void initWidgets() {
        spSection = findViewById(R.id.sp_section);
        btnSectionJoined = findViewById(R.id.btn_section_my_join);
        btnSectionCreated = findViewById(R.id.btn_section_my_create);
    }
}