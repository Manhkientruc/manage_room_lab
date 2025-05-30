package com.example.manage_room_lab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainAdminActivity extends Activity {

    Button btnManageRoom, btnManageDevice, btnManageUser, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        btnManageRoom = findViewById(R.id.btnManageRoom);
        btnManageDevice = findViewById(R.id.btnManageDevice);
        btnManageUser = findViewById(R.id.btnManageUser);
        btnLogout = findViewById(R.id.btnLogout);

        btnManageRoom.setOnClickListener(v -> showToast("Quản lý phòng máy"));
        btnManageDevice.setOnClickListener(v -> showToast("Quản lý thiết bị"));
        btnManageUser.setOnClickListener(v -> showToast("Quản lý người dùng"));
        btnLogout.setOnClickListener(v -> showToast("Đăng xuất"));
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
