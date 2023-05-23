package com.furkanozek.imhereproject.Bilgilerim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;

import com.furkanozek.imhereproject.EntranceScreen;
import com.furkanozek.imhereproject.R;

public class Bilgilerim extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgilerim);
        sharedPreferences = getSharedPreferences(EntranceScreen.MyPREFERENCES, Context.MODE_PRIVATE);
        EditText name = findViewById(R.id.editTextTextPersonName5);
        EditText bloodType = findViewById(R.id.editTextTextPersonName7);
        EditText ID = findViewById(R.id.editTextTextPersonName8);
        EditText phoneNumber = findViewById(R.id.editTextPhone2);

        name.setText(sharedPreferences.getString("Name",null) + " " + sharedPreferences.getString("Surname", null));
        bloodType.setText(sharedPreferences.getString("BloodType", null));
        ID.setText(sharedPreferences.getString("ID", null));
        phoneNumber.setText(sharedPreferences.getString("PhoneNumber", null));
    }
}