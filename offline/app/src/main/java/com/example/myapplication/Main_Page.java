package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.myapplication.databinding.ActivityMainPageBinding;
import com.example.myapplication.ui.home.HomeFragment;
import com.example.myapplication.ui.information.informationFragment;
import com.example.myapplication.ui.mine.mineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Main_Page extends AppCompatActivity {
    private ActivityMainPageBinding binding;
    private BottomNavigationView nav_view;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainPageBinding inflate = ActivityMainPageBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_information, R.id.navigation_mine).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main_page);
        NavigationUI.setupActionBarWithNavController((AppCompatActivity) this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController((NavigationBarView) this.binding.navView, navController);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        final Bundle bundle = getIntent().getExtras();
        int bid = bundle.getInt("bid");
        System.out.println(bid);
        this.nav_view = (BottomNavigationView) findViewById(R.id.nav_view);
        if (bid == 0) {
            HomeFragment hFragment = new HomeFragment();
            hFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main_page, hFragment).commit();
            this.nav_view.getMenu().findItem(R.id.navigation_home).setChecked(true);
        } else if (bid == 1) {
            informationFragment iFragment = new informationFragment();
            iFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main_page, iFragment).commit();
            this.nav_view.getMenu().findItem(R.id.navigation_information).setChecked(true);
        } else if (bid == 2) {
            mineFragment mFragment = new mineFragment();
            mFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main_page, mFragment).commit();
            this.nav_view.getMenu().findItem(R.id.navigation_mine).setChecked(true);
        }
        this.nav_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    HomeFragment hFragment = new HomeFragment();
                    hFragment.setArguments(bundle);
                    Main_Page.this.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main_page, hFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.navigation_information) {
                    informationFragment iFragment = new informationFragment();
                    iFragment.setArguments(bundle);
                    Main_Page.this.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main_page, iFragment).commit();
                    return true;
                } else if (item.getItemId() != R.id.navigation_mine) {
                    return false;
                } else {
                    mineFragment mFragment = new mineFragment();
                    mFragment.setArguments(bundle);
                    Main_Page.this.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main_page, mFragment).commit();
                    return true;
                }
            }
        });
        super.onResume();
    }
}
