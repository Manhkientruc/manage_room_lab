package com.example.manage_room_lab ;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class RegisterActivity extends Activity {
    EditText edtFullName, edtPhone, edtUsername, edtPassword, edtConfirmPassword;
    Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtFullName = findViewById(R.id.edtFullName);
        edtPhone = findViewById(R.id.edtPhone);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(v -> {
            Toast.makeText(this, "Đăng ký chưa xử lý!", Toast.LENGTH_SHORT).show();
        });
    }
}
