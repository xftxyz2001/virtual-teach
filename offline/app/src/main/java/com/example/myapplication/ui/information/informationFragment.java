package com.example.myapplication.ui.information;

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
import com.example.myapplication.databinding.FragmentInformationBinding;
import com.example.myapplication.news_announcement;
import com.example.myapplication.system_notifications;
import com.example.myapplication.virtual_teachResearch_section;

public class informationFragment extends Fragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private FragmentInformationBinding binding;
    String user_name;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        informationViewModel informationviewmodel = (informationViewModel) new ViewModelProvider(this).get(informationViewModel.class);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.user_name = bundle.getString("user_name");
            FragmentInformationBinding inflate = FragmentInformationBinding.inflate(inflater, container, false);
            this.binding = inflate;
            View root = inflate.getRoot();
            ((TextView) root.findViewById(R.id.address_book)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(informationFragment.this.getActivity(), news_announcement.class);
                    intent.putExtra("user_name", informationFragment.this.user_name);
                    informationFragment.this.startActivity(intent);
                }
            });
            ((TextView) root.findViewById(R.id.virtual_teachResearch_section)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(informationFragment.this.getActivity(), virtual_teachResearch_section.class);
                    intent.putExtra("user_name", informationFragment.this.user_name);
                    informationFragment.this.startActivity(intent);
                }
            });
            ((TextView) root.findViewById(R.id.meeting_reminder)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(informationFragment.this.getActivity(), Meeting_Reminder.class);
                    intent.putExtra("user_name", informationFragment.this.user_name);
                    informationFragment.this.startActivity(intent);
                }
            });
            ((TextView) root.findViewById(R.id.system_notifications)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(informationFragment.this.getActivity(), system_notifications.class);
                    intent.putExtra("user_name", informationFragment.this.user_name);
                    informationFragment.this.startActivity(intent);
                }
            });
            return root;
        }
        throw new AssertionError();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
