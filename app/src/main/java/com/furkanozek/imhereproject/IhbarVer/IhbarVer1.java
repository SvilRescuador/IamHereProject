package com.furkanozek.imhereproject.IhbarVer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.furkanozek.imhereproject.MainActivity;
import com.furkanozek.imhereproject.R;

public class IhbarVer1 extends AppCompatActivity {

    private static int neighborhoodCode;
    private static String bloodType;
    EditText phoneNumber;
    EditText nameSurname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ihbar_ver1);

        /* phoneNumber.findViewById(R.id.editTextTextPersonName12);
        nameSurname.findViewById(R.id.editTextTextPersonName10);


        phoneNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        phoneNumber.setFilters(new InputFilter[] { new InputFilter.LengthFilter(11) }); */


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
        class cityListener implements AdapterView.OnItemSelectedListener {



            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Ankara")) {
                    spinner3.setAdapter(adapter1);
                    neighborhoodCode = 10;
                }
                else if(selectedItem.equals("Manisa")) {
                    spinner3.setAdapter(adapter2);
                    neighborhoodCode = 10;
                }
                else if(selectedItem.equals("Tokat")) {
                    spinner3.setAdapter(adapter3);
                    neighborhoodCode = 10;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }

        class districtListener implements AdapterView.OnItemSelectedListener {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Çankaya") || selectedItem.equals("Akhisar") || selectedItem.equals("Niksar")) {
                    spinner4.setAdapter(adapter4);
                    neighborhoodCode = neighborhoodCode * 100;
                    neighborhoodCode += 1;
                }

                else if(selectedItem.equals("Gölbaşı") || selectedItem.equals("Saruhanlı") || selectedItem.equals("Turhal")) {
                    spinner4.setAdapter(adapter5);
                    neighborhoodCode = neighborhoodCode * 100;
                    neighborhoodCode += 2;
                }
                else if(selectedItem.equals("Beypazarı") || selectedItem.equals("Şehzadeler") || selectedItem.equals("Erbaa")) {
                    spinner4.setAdapter(adapter6);
                    neighborhoodCode = neighborhoodCode * 100;
                    neighborhoodCode += 3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }

        class neigborhoodListener implements AdapterView.OnItemSelectedListener {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Atatürk Mahallesi") || selectedItem.equals("Cumhuriyet Mahallesi") || selectedItem.equals("Karşıyaka Mahallesi")) {

                    neighborhoodCode = neighborhoodCode * 100;
                    neighborhoodCode += 1;
                }

                else if(selectedItem.equals("15 Temmuz Mahallesi") || selectedItem.equals("Hürriyet Mahallesi") || selectedItem.equals("Milliyet Mahallesi")) {

                    neighborhoodCode = neighborhoodCode * 100;
                    neighborhoodCode += 2;
                }
                else if(selectedItem.equals("Ulu Cami Mahallesi") || selectedItem.equals("Yıldırım Mahallesi") || selectedItem.equals("Fevzi Çakmak Mahallesi")) {

                    neighborhoodCode = neighborhoodCode * 100;
                    neighborhoodCode += 3;
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
        Intent intent = new Intent(IhbarVer1.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void makeNotice( View view){
        /* if(phoneNumber.getText().toString().length() != 11){
            Toast.makeText(getApplicationContext(), "Please enter correct phone number", Toast.LENGTH_SHORT).show();
        }else{

        } */


    }
}