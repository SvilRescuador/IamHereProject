package com.furkanozek.imhereproject;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.furkanozek.imhereproject.EntranceScreen;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notices {

    static FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static void noticesDatabase(int nCode, String buildingName, String nameSurname, String bloodType, String noticeBy, String phoneNumber){


        Map<String, Object> notice = new HashMap<>();
        notice.put("Name", nameSurname);
        notice.put("noticeBy", noticeBy);
        notice.put("PhoneNumber", phoneNumber);
        notice.put("BloodType", bloodType);
        notice.put("nCode" , nCode);
        notice.put("BuildingName", buildingName);

        db.collection("notices")
                .add(notice)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });



    }

    public static void findNotices(int neighborhoodCode, FirestoreCallback callback) {
        List<String> order = Arrays.asList("Name",  "BuildingName", "PhoneNumber", "BloodType", "noticeBy");
        List<String> dataList = new ArrayList<>();
        db.collection("notices").orderBy("Name")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map<String, Object> data = document.getData();
                                StringBuilder dataBuilder = new StringBuilder();
                                Map<Integer, String> orderedData = new HashMap<>();
                                int i = 0 ;
                                String[] names = {"Noticed by: " , "Address: " + newAddress.printAddress(neighborhoodCode)  + "" , "Phone Number: ", "Blood Type: " , "Name: " };
                                for (Map.Entry<String, Object> entry : data.entrySet()) {
                                    String key = entry.getKey();
                                    if (!key.equals("nCode") && order.contains(key)) {
                                        int index = order.indexOf(key);
                                        orderedData.put(index, names[i]  + entry.getValue().toString());
                                        i++;
                                    }
                                }
                                if((long) document.getData().get("nCode") == neighborhoodCode) {
                                    List<Integer> sortedKeys = new ArrayList<>(orderedData.keySet());
                                    Collections.sort(sortedKeys);
                                    for (int key : sortedKeys) {
                                        dataBuilder.append(orderedData.get(key)).append("\n");
                                    }
                                    dataList.add(dataBuilder.toString()); // This will be the text displayed for each item in the list
                                }
                            }
                            callback.onDataLoaded(dataList);
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public static void informFoundPeople(int nCode, String buildingName, String nameSurname, String bloodType, String noticeBy, String phoneNumber){


        Map<String, Object> notice = new HashMap<>();
        notice.put("Name", nameSurname);
        notice.put("noticeBy", noticeBy);
        notice.put("PhoneNumber", phoneNumber);
        notice.put("BloodType", bloodType);
        notice.put("nCode" , nCode);
        notice.put("BuildingName", buildingName);

        db.collection("found")
                .add(notice)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });



    }


    public static void findFounds(int neighborhoodCode, FirestoreCallback callback) {
        List<String> order = Arrays.asList("Name",  "BuildingName", "PhoneNumber", "BloodType", "noticeBy");
        List<String> dataList = new ArrayList<>();
        db.collection("found").orderBy("Name")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map<String, Object> data = document.getData();
                                StringBuilder dataBuilder = new StringBuilder();
                                Map<Integer, String> orderedData = new HashMap<>();
                                int i = 0 ;
                                String[] names = {"Noticed by: " , "Address: " + newAddress.printAddress(neighborhoodCode)  + "" , "Phone Number: ", "Blood Type: " , "Name: " };
                                for (Map.Entry<String, Object> entry : data.entrySet()) {
                                    String key = entry.getKey();
                                    if (!key.equals("nCode") && order.contains(key)) {
                                        int index = order.indexOf(key);
                                        orderedData.put(index, names[i]  + entry.getValue().toString());
                                        i++;
                                    }
                                }
                                if((long) document.getData().get("nCode") == neighborhoodCode) {
                                    List<Integer> sortedKeys = new ArrayList<>(orderedData.keySet());
                                    Collections.sort(sortedKeys);
                                    for (int key : sortedKeys) {
                                        dataBuilder.append(orderedData.get(key)).append("\n");
                                    }
                                    dataList.add(dataBuilder.toString()); // This will be the text displayed for each item in the list
                                }
                            }
                            callback.onDataLoaded(dataList);
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}




