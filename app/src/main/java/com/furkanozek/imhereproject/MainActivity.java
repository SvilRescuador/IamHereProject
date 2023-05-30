package com.furkanozek.imhereproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    static Boolean isNoticed = false;
    private MediaPlayer mediaPlayer;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(EntranceScreen.MyPREFERENCES, Context.MODE_PRIVATE);

        mediaPlayer = MediaPlayer.create(this, R.raw.sirensesi);

        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSiren();
            }
        });

    }


    private void playSiren() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    }
                }
            }, 28 * 1000);  // 30 seconds
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    public void helpMe(View view){


        if(isNoticed != true){
            Notices.noticesDatabase(sharedPreferences.getInt("nCode", 0), sharedPreferences.getString("BuildingName", null), sharedPreferences.getString("Name", null) + " " + sharedPreferences.getString("Surname", null), sharedPreferences.getString("BloodType", null), "him/herself", sharedPreferences.getString("PhoneNumber", null));
            Toast.makeText(getApplicationContext(), "Notice is created", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "You've already made a notice", Toast.LENGTH_SHORT).show();
        }
        isNoticed = true ;
    }

    public void ihbarVer(View view){
        Intent intent = new Intent(MainActivity.this, IhbarVer1.class);
        startActivity(intent);
    }

    public void guncelIhbar(View view){
        Intent intent = new Intent(MainActivity.this, GuncelIhbar.class);
        startActivity(intent);
    }

    public void bilgiler(View view){
        Intent intent = new Intent(MainActivity.this, Bilgilerim.class);
        startActivity(intent);
    }

}