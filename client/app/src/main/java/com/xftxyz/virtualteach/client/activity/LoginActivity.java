package com.xftxyz.virtualteach.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.util.OkHttpManager;
import com.xftxyz.virtualteach.client.util.ResultHandler;
import com.xftxyz.virtualteach.client.util.UserPreferences;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;

    private Button btnRegister;
    private Button btnForget;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        initWidgets();
        initListeners();
    }

    private void initListeners() {
        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        btnForget.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
        });

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            if (username.isEmpty() || password.isEmpty()) {
                new AlertDialog.Builder(LoginActivity.this)
                        .setTitle("提示")
                        .setMessage("用户名或密码不能为空")
                        .setPositiveButton("确定", null)
                        .show();
                return;
            }
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("login", username);
            requestBody.put("password", password);
            OkHttpManager.post("/api/user/login", requestBody, new ResultHandler(LoginActivity.this) {

                @Override
                public void onSuccess(Object data) throws Exception {
                    JSONObject res = (JSONObject) data;
                    UserPreferences.saveToken(res.getString("token"));
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            });
        });
    }

    private void initWidgets() {
        etUsername = findViewById(R.id.et_login_username);
        etPassword = findViewById(R.id.et_login_password);

        btnRegister = findViewById(R.id.btn_register);
        btnForget = findViewById(R.id.btn_forget_password);
        btnLogin = findViewById(R.id.btn_login);
    }
}