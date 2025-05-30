package com.example.manage_room_lab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

public class RoomListActivity extends Activity {

    GridView gridRooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);

        gridRooms = findViewById(R.id.gridRooms);

        String[] rooms = {"Phòng M.501", "Phòng M.502", "Phòng M.503", "Phòng M.504", "Phòng M.505", "Phòng M.506"};
        RoomAdapter adapter = new RoomAdapter(this, rooms);
        gridRooms.setAdapter(adapter);

        gridRooms.setOnItemClickListener((parent, view, position, id) -> {
            String room = rooms[position];
            Toast.makeText(this, "Chọn " + room, Toast.LENGTH_SHORT).show();
        });
    }
}
