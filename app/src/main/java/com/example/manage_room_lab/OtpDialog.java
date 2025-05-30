package com.example.manage_room_lab;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.*;

public class OtpDialog extends Dialog {

    EditText edtOtpCode;
    Button btnVerifyOtp;

    public OtpDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_otp);

        edtOtpCode = findViewById(R.id.edtOtpCode);
        btnVerifyOtp = findViewById(R.id.btnVerifyOtp);

        btnVerifyOtp.setOnClickListener(v -> {
            String code = edtOtpCode.getText().toString().trim();
            if (code.length() == 6) {
                dismiss(); // Giả sử mã đúng
                showResetPasswordDialog();
            } else {
                Toast.makeText(getContext(), "Mã OTP phải gồm 6 số", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showResetPasswordDialog() {
        Dialog resetDialog = new ResetPasswordDialog(getContext());
        resetDialog.show();
    }
}
