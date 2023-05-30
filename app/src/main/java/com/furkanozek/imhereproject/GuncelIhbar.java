package com.furkanozek.imhereproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GuncelIhbar extends AppCompatActivity {

    private static int neighborhoodCode;
    private static int cityCode;
    private static int districtCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncel_ihbar);

        // Initialize the Spinner
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);
        Spinner spinner4 = findViewById(R.id.spinner5);

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

        class neigborhoodListener implements AdapterView.OnItemSelectedListener {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Atatürk Mahallesi") || selectedItem.equals("Cumhuriyet Mahallesi") || selectedItem.equals("Karşıyaka Mahallesi")) {

                    neighborhoodCode = cityCode * 10000 + districtCode * 100 + 1;
                }

                else if(selectedItem.equals("Kazım Karabekir Mahallesi") || selectedItem.equals("Hürriyet Mahallesi") || selectedItem.equals("Milliyet Mahallesi")) {

                    neighborhoodCode = cityCode * 10000 + districtCode * 100 + 2;
                }
                else if(selectedItem.equals("Ulucami Mahallesi") || selectedItem.equals("Yıldırım Mahallesi") || selectedItem.equals("Fevzi Çakmak Mahallesi")) {

                    neighborhoodCode = cityCode * 10000 + districtCode * 100 + 3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }


        cityListener cityListener = new cityListener();
        spinner2.setOnItemSelectedListener(cityListener);
        districtListener districtListener = new districtListener();
        spinner3.setOnItemSelectedListener(districtListener);
        neigborhoodListener neigborhoodListener = new neigborhoodListener();
        spinner4.setOnItemSelectedListener(neigborhoodListener);






        // Specify the layout to use when the list of choices appears
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);





        // Apply the adapter to the spinner


        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);





        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items1, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter);

    }

    public void search (View view) {
        Intent intent = new Intent(GuncelIhbar.this, ihbarListesi.class);
        startActivity(intent);
        finish();
    }


    public void back ( View view){
        Intent intent = new Intent(GuncelIhbar.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public static int getNeighborhoodCode(){
        return neighborhoodCode;
    }
}