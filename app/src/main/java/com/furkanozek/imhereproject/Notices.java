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
import java.util.HashMap;
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


        /*String b;

        */

    }

    public static ArrayList<String> findNotices(int neighborhoodCode){
        ArrayList<String> notices = new ArrayList<>();

        db.collection("notices")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Map<String, Object> data = document.getData();

                                int nCode = (int) data.get("nCode");
                                if(nCode == neighborhoodCode) {
                                    String bName = new String((String) data.get("BuildingName"));
                                    notices.add(bName);
                                }
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

        return notices;
    }

}
