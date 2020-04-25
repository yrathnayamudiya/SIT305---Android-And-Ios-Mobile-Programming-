package com.example.lastonetest;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dashboard extends AppCompatActivity {
    private ActionBar toolbar;
    public static String imi_id=null;
    public static String sim_id=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_bar);
        toolbar = getSupportActionBar();
        toolbar.setTitle("Available Router");
    }


}