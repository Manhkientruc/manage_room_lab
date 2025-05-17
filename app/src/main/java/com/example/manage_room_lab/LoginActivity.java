package com.example.manage_room_lab;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private CheckBox rememberMe;
    private Button btnLogin;
    private TextView forgotPassword, register;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ánh xạ các view từ layout
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        rememberMe = findViewById(R.id.rememberMe);
        btnLogin = findViewById(R.id.loginButton);
        forgotPassword = findViewById(R.id.forgotPassword);
        register = findViewById(R.id.register);

        // Gạch chân chữ "Đăng ký"
        register.setPaintFlags(register.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // Khởi tạo database helper
        dbHelper = new DatabaseHelper(this);

        // Sự kiện nút Đăng nhập
        btnLogin.setOnClickListener(v -> {
            String inputUsername = username.getText().toString().trim();
            String inputPassword = password.getText().toString();

            if (dbHelper.checkUser(inputUsername, inputPassword)) {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                // TODO: chuyển sang màn hình chính
            } else {
                Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        // Sự kiện quên mật khẩu
        forgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        // Sự kiện chuyển sang giao diện đăng ký
        register.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
