package com.example.manage_room_lab;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText etFullName, etPhone, etUsername, etPassword, etRePassword;
    private Button btnRegister;

    private DatabaseHelper dbHelper;  // Thêm biến DatabaseHelper

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Khởi tạo DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Ánh xạ view
        etFullName = findViewById(R.id.usernamee);   // Tên người dùng
        etPhone = findViewById(R.id.mobile);         // Số điện thoại
        etUsername = findViewById(R.id.username);    // Tên đăng nhập
        etPassword = findViewById(R.id.password);    // Mật khẩu
        etRePassword = findViewById(R.id.repassword);// Nhập lại mật khẩu
        btnRegister = findViewById(R.id.loginButton); // Nút đăng ký

        btnRegister.setOnClickListener(v -> {
            String fullName = etFullName.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString();
            String rePassword = etRePassword.getText().toString();

            // Kiểm tra hợp lệ
            if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(phone)
                    || TextUtils.isEmpty(username) || TextUtils.isEmpty(password)
                    || TextUtils.isEmpty(rePassword)) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(rePassword)) {
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            // Kiểm tra xem username đã tồn tại chưa
            if (dbHelper.checkUserExist(username)) {
                Toast.makeText(this, "Tên đăng nhập đã tồn tại", Toast.LENGTH_SHORT).show();
                return;
            }

            // Thêm người dùng mới vào database
            boolean inserted = dbHelper.addUser(fullName, phone, username, password);
            if (inserted) {
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                // Quay về màn hình đăng nhập
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Đăng ký thất bại, vui lòng thử lại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
