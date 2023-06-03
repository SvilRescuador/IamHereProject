package com.furkanozek.imhereproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
//In this class, actions are taken regarding the people who survived the wreckage.
public class Bulunanlar extends AppCompatActivity {

    private static int neighborhoodCode;
    private static int cityCode;
    private static int districtCode;
    private static String bloodType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ihbar_ver1);



        neighborhoodCode = 0;

        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner2 = findViewById(R.id.spinner6);
        Spinner spinner3 = findViewById(R.id.spinner5);
        Spinner spinner4 = findViewById(R.id.spinner7);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(this,
                R.array.spinner_items1, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.spinner_itemsAnkara, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.spinner_itemsManisa, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.spinner_itemsTokat, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.spinner_items1ilceler, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.spinner_items2ilceler, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this,
                R.array.spinner_items3ilceler, android.R.layout.simple_spinner_item);

        //Listener for city spinner: determines the district spinner's items.
        class cityListener implements AdapterView.OnItemSelectedListener {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Ankara")) {
                    spinner3.setAdapter(adapter1);
                    cityCode = 10;
                }
                else if(selectedItem.equals("Manisa")) {
                    spinner3.setAdapter(adapter2);
                    cityCode = 11;
                }
                else if(selectedItem.equals("Tokat")) {
                    spinner3.setAdapter(adapter3);
                    cityCode = 12;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }

        //Listener for district spinner: determines the neighborhood spinner's items.
        class districtListener implements AdapterView.OnItemSelectedListener {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Çankaya") || selectedItem.equals("Akhisar") || selectedItem.equals("Niksar")) {
                    spinner4.setAdapter(adapter4);
                    districtCode = 1;
                }

                else if(selectedItem.equals("Gölbaşı") || selectedItem.equals("Saruhanlı") || selectedItem.equals("Turhal")) {
                    spinner4.setAdapter(adapter5);
                    districtCode = 2;
                }
                else if(selectedItem.equals("Beypazarı") || selectedItem.equals("Şehzadeler") || selectedItem.equals("Erbaa")) {
                    spinner4.setAdapter(adapter6);
                    districtCode = 3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }

        //Listener for neighborhood spinner: calculates the neighborhod code according to choosen city, district, neigborhood
        class neigborhoodListener implements AdapterView.OnItemSelectedListener {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Atatürk Mahallesi") || selectedItem.equals("Kazım Karabekir Mahallesi") || selectedItem.equals("Ulucami Mahallesi")) {

                    neighborhoodCode = cityCode * 10000 + districtCode * 100 + 1;
                }

                else if(selectedItem.equals("Hürriyet Mahallesi") || selectedItem.equals("Cumhuriyet Mahallesi") || selectedItem.equals("Yıldırım Mahallesi")) {

                    neighborhoodCode = cityCode * 10000 + districtCode * 100 + 2;
                }
                else if(selectedItem.equals("Karşıyaka Mahallesi") || selectedItem.equals("Milliyet Mahallesi") || selectedItem.equals("Fevzi Çakmak Mahallesi")) {

                    neighborhoodCode = cityCode * 10000 + districtCode * 100 + 3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }
        // Initialize the Spinner

        class bloodTypeListener implements AdapterView.OnItemSelectedListener {
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
        }

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter0);
        bloodTypeListener bloodTypeListener = new bloodTypeListener();
        spinner.setOnItemSelectedListener(bloodTypeListener);
        cityListener cityListener = new cityListener();
        spinner2.setOnItemSelectedListener(cityListener);
        districtListener districtListener = new districtListener();
        spinner3.setOnItemSelectedListener(districtListener);
        neigborhoodListener neigborhoodListener = new neigborhoodListener();
        spinner4.setOnItemSelectedListener(neigborhoodListener);
    }

    public void back ( View view){
        Intent intent = new Intent(Bulunanlar.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void makeNotice( View view){
        SharedPreferences sharedPreferences = getSharedPreferences(EntranceScreen.MyPREFERENCES, Context.MODE_PRIVATE);
        EditText buildingName = findViewById(R.id.editTextTextPersonName14);
        EditText nameSurname = findViewById(R.id.editTextTextPersonName10);
        EditText phoneNumber = findViewById(R.id.editTextTextPersonName12);

        if(nameSurname.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Please enter name and surname", Toast.LENGTH_SHORT).show();
        }else if(phoneNumber.getText().toString().isEmpty() || phoneNumber.getText().toString().length() != 11){
            Toast.makeText(getApplicationContext(), "Please enter valid phone number", Toast.LENGTH_SHORT).show();
        }else if((neighborhoodCode <= 99999 || neighborhoodCode >= 133333)){
            Toast.makeText(getApplicationContext(), "Please enter address", Toast.LENGTH_SHORT).show();
        }else{
            Notices.informFoundPeople(neighborhoodCode, buildingName.getText().toString(), nameSurname.getText().toString(), bloodType, sharedPreferences.getString("Name", null) + " " + sharedPreferences.getString("Surname", null), phoneNumber.getText().toString());
            Toast.makeText(getApplicationContext(), "Notice is created", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Bulunanlar.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}


