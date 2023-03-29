package com.furkanozek.imhereproject.HelpMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.furkanozek.imhereproject.MainActivity;
import com.furkanozek.imhereproject.R;

public class HelpMe1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_me1);
    }

    public void BackButton(View view){
        Intent intent = new Intent(HelpMe1.this, MainActivity.class);
        startActivity(intent);
    }

    public void guncelAdresiKullan(){

    }

    public void adresGuncelle(View view){

    }


}