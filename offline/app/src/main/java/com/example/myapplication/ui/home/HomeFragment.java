package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication.Meeting_Reminder;
import com.example.myapplication.R;
import com.example.myapplication.course_management;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.editPersonalInfo;
import com.example.myapplication.homework_management;
import com.example.myapplication.news_announcement;
import com.example.myapplication.setting;
import com.example.myapplication.store;
import com.example.myapplication.system_notifications;
import com.example.myapplication.virtual_teachResearch_section;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    String user_name;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeViewModel homeViewModel = (HomeViewModel) new ViewModelProvider(this).get(HomeViewModel.class);
        FragmentHomeBinding inflate = FragmentHomeBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        this.user_name = (String) store.get("user_name");
        ((TextView) root.findViewById(R.id.go_to_news)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), news_announcement.class);
                intent.putExtra("user_name", HomeFragment.this.user_name);
                HomeFragment.this.startActivity(intent);
            }
        });
        ((TextView) root.findViewById(R.id.go_to_section)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), virtual_teachResearch_section.class);
                intent.putExtra("user_name", HomeFragment.this.user_name);
                HomeFragment.this.startActivity(intent);
            }
        });
        ((TextView) root.findViewById(R.id.go_to_meeting)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), Meeting_Reminder.class);
                intent.putExtra("user_name", HomeFragment.this.user_name);
                HomeFragment.this.startActivity(intent);
            }
        });
        ((TextView) root.findViewById(R.id.go_to_system)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), system_notifications.class);
                intent.putExtra("user_name", HomeFragment.this.user_name);
                HomeFragment.this.startActivity(intent);
            }
        });
        ((TextView) root.findViewById(R.id.go_to_self)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), editPersonalInfo.class);
                intent.putExtra("user_name", HomeFragment.this.user_name);
                HomeFragment.this.startActivity(intent);
            }
        });
        ((TextView) root.findViewById(R.id.go_to_myCourse)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), course_management.class);
                intent.putExtra("user_name", HomeFragment.this.user_name);
                HomeFragment.this.startActivity(intent);
            }
        });
        ((TextView) root.findViewById(R.id.go_to_myOutput)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), homework_management.class);
                intent.putExtra("user_name", HomeFragment.this.user_name);
                HomeFragment.this.startActivity(intent);
            }
        });
        ((TextView) root.findViewById(R.id.go_to_setting)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), setting.class);
                intent.putExtra("user_name", HomeFragment.this.user_name);
                HomeFragment.this.startActivity(intent);
            }
        });
        return root;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
