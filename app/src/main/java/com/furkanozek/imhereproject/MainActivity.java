package com.furkanozek.imhereproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.furkanozek.imhereproject.Bilgilerim.Bilgilerim;
import com.furkanozek.imhereproject.GuncelIhbar.GuncelIhbar;
import com.furkanozek.imhereproject.HelpMe.HelpMe1;
import com.furkanozek.imhereproject.IhbarVer.IhbarVer1;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences(EntranceScreen.MyPREFERENCES, Context.MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void helpMe(View view){
        Intent intent = new Intent(MainActivity.this, HelpMe1.class);
        startActivity(intent);

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