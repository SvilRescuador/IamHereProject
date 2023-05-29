package com.furkanozek.imhereproject;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntranceScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static String bloodType;
    EditText name;
    EditText surname;
    EditText ID;
    EditText phoneNumber;
    String address ;
    SharedPreferences sharedPreferences;
    FirebaseFirestore db ;
    ArrayList<String> validIDs = new ArrayList<>();
    public static final String MyPREFERENCES = "MyPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        validIDs.add("45766659840");
        validIDs.add("11378536788");
        validIDs.add("52145668850");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance_screen);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();


        address = newAddress.printAddress(adresGuncelle.getNeighborhoodCode()) + " " + sharedPreferences.getString("BuildingName", null);


        name = findViewById(R.id.editTextTextPersonName);
        surname = findViewById(R.id.editTextTextPersonName3);
        ID = findViewById(R.id.editTextTextPersonName4);
        phoneNumber = findViewById(R.id.editTextTextPersonName6);


        ID.setInputType(InputType.TYPE_CLASS_NUMBER);
        ID.setFilters(new InputFilter[] { new InputFilter.LengthFilter(11) });
        phoneNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        phoneNumber.setFilters(new InputFilter[] { new InputFilter.LengthFilter(11) });

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
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }

    public void signUp (View view) {



        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(phoneNumber.getText().toString().length() != 11){
            Toast.makeText(getApplicationContext(), "Please enter correct phone number" , Toast.LENGTH_SHORT).show();
        }else if(ID.getText().toString().length() != 11){
            Toast.makeText(getApplicationContext(), "Please enter correct ID" , Toast.LENGTH_SHORT).show();
        }else {
            editor.putString("Name", name.getText().toString()).apply();
            editor.putString("Surname", surname.getText().toString()).apply();
            editor.putString("ID", ID.getText().toString()).apply();
            editor.putString("PhoneNumber", phoneNumber.getText().toString()).apply();
            editor.putString("BloodType", bloodType).apply();
            editor.putBoolean("hasSavedInfo", true).apply();

            db = FirebaseFirestore.getInstance();


            Map<String, Object> user = new HashMap<>();
            user.put("Name", name.getText().toString() );
            user.put("Surname", surname.getText().toString());
            user.put("ID", ID.getText().toString());
            user.put("PhoneNumber", phoneNumber.getText().toString());
            user.put("BloodType", bloodType);
            user.put("Address" , address);



            for(int k = 0 ; k < validIDs.size() ; k++){
                if(!ID.getText().toString().equals(validIDs.get(k))){
                    Intent intent = new Intent(EntranceScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else if(k == validIDs.size() -1 ){
                    Toast.makeText(getApplicationContext(),"Please enter a valid ID" , Toast.LENGTH_SHORT).show();
                }
            }



        }

    }


}

