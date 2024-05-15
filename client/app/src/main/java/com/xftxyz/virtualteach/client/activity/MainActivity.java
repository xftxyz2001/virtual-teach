package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.fragment.HomeFragment;
import com.xftxyz.virtualteach.client.fragment.InformationFragment;
import com.xftxyz.virtualteach.client.fragment.MineFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initWidgets();
        initListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initListeners() {
        System.out.println(1);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            System.out.println(2);
            int itemId = item.getItemId();
            FragmentManager supportFragmentManager = MainActivity.this.getSupportFragmentManager();
            if (itemId == R.id.navigation_home) {
                // 切换到首页
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_activity_main, HomeFragment.class, null)
                        .commit();
            } else if (itemId == R.id.navigation_information) {
                // 切换到资讯
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_activity_main, InformationFragment.class, null)
                        .commit();
            } else if (itemId == R.id.navigation_mine) {
                // 切换到我的
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_activity_main, MineFragment.class, null)
                        .commit();
            }
            return true;
        });
    }

    private void initWidgets() {
        bottomNavigationView = findViewById(R.id.nav_view);
    }
}