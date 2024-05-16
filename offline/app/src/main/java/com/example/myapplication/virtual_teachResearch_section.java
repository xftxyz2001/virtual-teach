package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class virtual_teachResearch_section extends AppCompatActivity {
    private String[] section = {"", "创建虚拟教研室", "加入虚拟教研室"};
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_virtual_teach_research_section);
        this.user_name = getIntent().getStringExtra("user_name");
        initSpinnerForSection();
    }

    public void create_teachResearch_section(View view) {
        Intent intent = new Intent(this, create_virtual_teachResearch_section.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void join_teachResearch_section(View view) {
        Intent intent = new Intent(this, join_teachResearch_section.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void go_to_myJoin_section(View view) {
        Intent intent = new Intent(this, MyJoinSection.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void go_to_myCreate_section(View view) {
        Intent intent = new Intent(this, MyCreateSection.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void back_to_information(View view) {
        Intent intent = new Intent();
        intent.setClass(this, Main_Page.class);
        Bundle bundle = new Bundle();
        bundle.putString("user_name", this.user_name);
        bundle.putInt("bid", 1);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void initSpinnerForSection() {
        ArrayAdapter<String> section_adapter = new ArrayAdapter<>(this, 17367043, this.section);
        Spinner sp_section = (Spinner) findViewById(R.id.sp_section);
        sp_section.setAdapter(section_adapter);
        sp_section.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                if (arg2 == 1) {
                    virtual_teachResearch_section.this.create_teachResearch_section(arg1);
                } else if (arg2 == 2) {
                    virtual_teachResearch_section.this.join_teachResearch_section(arg1);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
