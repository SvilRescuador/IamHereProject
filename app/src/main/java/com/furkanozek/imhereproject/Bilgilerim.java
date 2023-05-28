package com.furkanozek.imhereproject;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.furkanozek.imhereproject.GuncelIhbar.GuncelIhbar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

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

        phoneNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        phoneNumber.setFilters(new InputFilter[] { new InputFilter.LengthFilter(11) });

        int nCode = sharedPreferences.getInt("nCode",20);
        //int nCode = adresGuncelle.getNeighborhoodCode();
        name.setText(sharedPreferences.getString("Name",null) + " " + sharedPreferences.getString("Surname", null));
        bloodType.setText(sharedPreferences.getString("BloodType", null));
        ID.setText(sharedPreferences.getString("ID", null));

        address.setText(newAddress.printAddress(nCode) + " " + sharedPreferences.getString("BuildingName", null));

        phoneNumber.setText(sharedPreferences.getString("PhoneNumber", null));


    }

    public void changeAddress(View view) {
        Intent intent = new Intent(Bilgilerim.this, adresGuncelle.class);
        startActivity(intent);
    }

    public void updateCred(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(phoneNumber.getText().toString().length() != 11) {
            Toast.makeText(getApplicationContext(), "Please enter correct phone number", Toast.LENGTH_SHORT).show();
        }else{
            editor.putString("PhoneNumber", phoneNumber.getText().toString()).apply();
            //phoneNumber.setText(sharedPreferences.getString("PhoneNumber", null));
            Intent intent = new Intent(Bilgilerim.this, MainActivity.class);
            startActivity(intent);
        }

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