package com.example.manage_room_lab;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ForgotPasswordActivity extends Activity {
    EditText edtPhoneForgot;
    Button btnSendCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edtPhoneForgot = findViewById(R.id.edtPhoneForgot);
        btnSendCode = findViewById(R.id.btnSendCode);

        btnSendCode.setOnClickListener(v -> {
            // Sau này bạn sẽ xử lý gửi mã OTP ở đây
            showOtpDialog();
        });
    }

    private void showOtpDialog() {
        Dialog dialog = new OtpDialog(this);
        dialog.show();
    }
}
