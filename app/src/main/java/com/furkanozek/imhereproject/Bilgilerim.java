package com.furkanozek.imhereproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.furkanozek.imhereproject.GuncelIhbar.GuncelIhbar;

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
        TextView address = findViewById(R.id.textView3);
        phoneNumber = findViewById(R.id.editTextPhone2);

        int nCode = sharedPreferences.getInt("nCode",20);
        //int nCode = adresGuncelle.getNeighborhoodCode();
        name.setText(sharedPreferences.getString("Name",null) + " " + sharedPreferences.getString("Surname", null));
        bloodType.setText(sharedPreferences.getString("BloodType", null));
        ID.setText(sharedPreferences.getString("ID", null));

        address.setText(" " + sharedPreferences.getString("BuildingName", null) + " " + newAddress.printAddress(nCode));

        phoneNumber.setText(sharedPreferences.getString("PhoneNumber", null));
    }

    public void changeAddress(View view) {
        Intent intent = new Intent(Bilgilerim.this, adresGuncelle.class);
        startActivity(intent);
    }

    public void updateCred(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("PhoneNumber", phoneNumber.getText().toString()).apply();
        //phoneNumber.setText(sharedPreferences.getString("PhoneNumber", null));
        Intent intent = new Intent(Bilgilerim.this, MainActivity.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(Bilgilerim.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /*private String decodeNCode(int nCode) {
        sharedPreferences = getSharedPreferences(EntranceScreen.MyPREFERENCES, Context.MODE_PRIVATE);
        String addressText = newAddress.findCityByCode(nCode) + " " + newAddress.findDistrictByCode(nCode) + " " + newAddress.findNeighborhoodByCode(nCode) +
                sharedPreferences.getString("BuildingName", null);
        return addressText;
    }*/
}