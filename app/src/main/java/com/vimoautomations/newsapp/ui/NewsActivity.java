package com.vimoautomations.newsapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vimoautomations.newsapp.R;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Log.i("Item selected ID"," clicked item"+ bottomNavigationView.getSelectedItemId());
    }
}