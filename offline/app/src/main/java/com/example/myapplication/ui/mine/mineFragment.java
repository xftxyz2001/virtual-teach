package com.example.myapplication.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication.R;
import com.example.myapplication.course_management;
import com.example.myapplication.databinding.FragmentMineBinding;
import com.example.myapplication.editPersonalInfo;
import com.example.myapplication.homework_management;
import com.example.myapplication.setting;

public class mineFragment extends Fragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private FragmentMineBinding binding;
    /* access modifiers changed from: private */
    public String user_name;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.user_name = bundle.getString("user_name");
            mineViewModel mineviewmodel = (mineViewModel) new ViewModelProvider(this).get(mineViewModel.class);
            FragmentMineBinding inflate = FragmentMineBinding.inflate(inflater, container, false);
            this.binding = inflate;
            View root = inflate.getRoot();
            TextView go_to_editPersonalInfo = (TextView) root.findViewById(R.id.edit_personal_info);
            go_to_editPersonalInfo.setText(this.user_name);
            go_to_editPersonalInfo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(mineFragment.this.getActivity(), editPersonalInfo.class);
                    intent.putExtra("user_name", mineFragment.this.user_name);
                    mineFragment.this.startActivity(intent);
                }
            });
            ((TextView) root.findViewById(R.id.course_management)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(mineFragment.this.getActivity(), course_management.class);
                    intent.putExtra("user_name", mineFragment.this.user_name);
                    mineFragment.this.startActivity(intent);
                }
            });
            ((TextView) root.findViewById(R.id.homework_management)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    mineFragment.this.startActivity(new Intent(mineFragment.this.getActivity(), homework_management.class));
                }
            });
            ((TextView) root.findViewById(R.id.setting)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(mineFragment.this.getActivity(), setting.class);
                    intent.putExtra("user_name", mineFragment.this.user_name);
                    mineFragment.this.startActivity(intent);
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
