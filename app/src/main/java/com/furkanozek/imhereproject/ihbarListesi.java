package com.furkanozek.imhereproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.furkanozek.imhereproject.R;

import java.util.List;


public class ihbarListesi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ihbar_listesi);

        ListView listView = findViewById(R.id.list_view);  // assuming this is the id of your ListView

        Notices.findNotices(GuncelIhbar.getNeighborhoodCode(), new FirestoreCallback() {
            public void onDataLoaded(List<String> data) {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        ihbarListesi.this,
                        android.R.layout.simple_list_item_1,  // This is a built-in layout for list items
                        data
                );
                listView.setAdapter(adapter);
            }
        });
        /*for(int a = 0; a < Notices.findNotices(GuncelIhbar.getNeighborhoodCode()).size(); a++) {
            String newElement = new String(Notices.findNotices(GuncelIhbar.getNeighborhoodCode()).get(a));
            text += "\n" + newElement;
            list.setText(text);
        }*/
    }

    public void back(View view) {
        Intent intent = new Intent(ihbarListesi.this, GuncelIhbar.class);
        startActivity(intent);
        finish();
    }
}