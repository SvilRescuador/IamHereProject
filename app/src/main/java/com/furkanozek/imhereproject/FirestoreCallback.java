package com.furkanozek.imhereproject;

import java.util.List;

interface FirestoreCallback {
    void onDataLoaded(List<String> data);
}