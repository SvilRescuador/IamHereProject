package com.furkanozek.imhereproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.furkanozek.imhereproject.R;


public class ihbarListesi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ihbar_listesi);

        TextView dataTextView = findViewById(R.id.textView5);  // assuming this is the id of your TextView
        Notices.findNotices(GuncelIhbar.getNeighborhoodCode(), new FirestoreCallback() {
            @Override
            public void onDataLoaded(String data) {
                dataTextView.setText(data);
            }
        });

        /*for(int a = 0; a < Notices.findNotices(GuncelIhbar.getNeighborhoodCode()).size(); a++) {
            String newElement = new String(Notices.findNotices(GuncelIhbar.getNeighborhoodCode()).get(a));
            text += "\n" + newElement;
            list.setText(text);
        }*/
    }

    public void bClick(View view) {
        Toast.makeText(getApplicationContext(), "deneme", Toast.LENGTH_SHORT).show();

    }
}