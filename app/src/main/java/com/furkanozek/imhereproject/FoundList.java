package com.furkanozek.imhereproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class FoundList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_list);

        ListView listView = findViewById(R.id.list_view);  // assuming this is the id of your ListView

        Notices.findFounds(GuncelIhbar.getNeighborhoodCode(), new FirestoreCallback() {
            public void onDataLoaded(List<String> data) {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(FoundList.this, android.R.layout.simple_list_item_1, data);
                listView.setAdapter(adapter);
            }
        });

    }

    public void back(View view) {
        Intent intent = new Intent(FoundList.this, GuncelIhbar.class);
        startActivity(intent);
        finish();
    }

}