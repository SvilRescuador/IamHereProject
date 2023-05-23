package com.furkanozek.imhereproject.Bilgilerim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.furkanozek.imhereproject.EntranceScreen;
import com.furkanozek.imhereproject.MainActivity;
import com.furkanozek.imhereproject.R;
import com.furkanozek.imhereproject.adresGuncelle;

public class Bilgilerim extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgilerim);
        sharedPreferences = getSharedPreferences(EntranceScreen.MyPREFERENCES, Context.MODE_PRIVATE);
        TextView name = findViewById(R.id.textView2);
        TextView bloodType = findViewById(R.id.textView9);
        TextView ID = findViewById(R.id.textView11);
        phoneNumber = findViewById(R.id.editTextPhone2);

        name.setText(sharedPreferences.getString("Name",null) + " " + sharedPreferences.getString("Surname", null));
        bloodType.setText(sharedPreferences.getString("BloodType", null));
        ID.setText(sharedPreferences.getString("ID", null));
        phoneNumber.setText(sharedPreferences.getString("PhoneNumber", null));
    }

    public void changeAddress() {
        Intent intent = new Intent(Bilgilerim.this, adresGuncelle.class);
        startActivity(intent);

    }

    public void updateCred() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("PhoneNumber", phoneNumber.getText().toString()).apply();
        //phoneNumber.setText(sharedPreferences.getString("PhoneNumber", null));
        Intent intent = new Intent(Bilgilerim.this, MainActivity.class);
        startActivity(intent);

    }
}