package com.example.manage_room_lab;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText editTextMobile;
    private Button btnGetOtp;

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        // Khởi tạo DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Ánh xạ view
        editTextMobile = findViewById(R.id.mobile);
        btnGetOtp = findViewById(R.id.loginButton);

        btnGetOtp.setOnClickListener(v -> {
            String mobile = editTextMobile.getText().toString().trim();

            if (mobile.isEmpty()) {
                Toast.makeText(ForgotPasswordActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                return;
            }

            // Kiểm tra số điện thoại đã đăng ký chưa
            boolean exists = dbHelper.checkMobileExist(mobile);
            if (exists) {
                // TODO: Gửi mã OTP đến số điện thoại (chưa triển khai)
                Toast.makeText(ForgotPasswordActivity.this, "Đã gửi mã OTP đến số: " + mobile, Toast.LENGTH_SHORT).show();

                // Có thể chuyển sang màn hình nhập OTP nếu có
                // startActivity(new Intent(ForgotPasswordActivity.this, OtpVerificationActivity.class));
            } else {
                Toast.makeText(ForgotPasswordActivity.this, "Số điện thoại chưa được đăng ký", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
