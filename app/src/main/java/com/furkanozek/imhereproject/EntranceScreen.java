package com.furkanozek.imhereproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EntranceScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static String bloodType;
    EditText name;
    EditText surname;
    EditText ID;
    EditText phoneNumber;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance_screen);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        name = findViewById(R.id.editTextTextPersonName);
        surname = findViewById(R.id.editTextTextPersonName3);
        ID = findViewById(R.id.editTextTextPersonName4);
        phoneNumber = findViewById(R.id.editTextTextPersonName6);

        // Initialize the Spinner
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Get the selected item's text
        String selectedItem = parent.getItemAtPosition(position).toString();

        // Do something with the selected item
        if(!selectedItem.equals("Blood Type")){
            bloodType = selectedItem;
            Toast.makeText(parent.getContext(), "Selected: " + selectedItem, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }

    public void signUp (View view) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", name.getText().toString()).apply();
        editor.putString("Surname", surname.getText().toString()).apply();
        editor.putString("ID", ID.getText().toString()).apply();
        editor.putString("PhoneNumber", phoneNumber.getText().toString()).apply();
        editor.putString("BloodType", bloodType).apply();
        editor.putBoolean("hasSavedInfo", true).apply();
        Toast.makeText(this, "Selected: " + sharedPreferences.getString("Name", ""), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(EntranceScreen.this, MainActivity.class);
        startActivity(intent);
    }
}

