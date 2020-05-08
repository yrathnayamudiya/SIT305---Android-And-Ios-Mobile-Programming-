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
    public static String imi_id = null;
    public static String sim_id = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_bar);
        navigation.setOnNavigationItemSelectedListener(navilist);
        toolbar = getSupportActionBar();
        toolbar.setTitle("Available Router");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Fragment fragment;
        fragment = new add_router();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_layout, fragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navilist = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment fragment;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.page_1:
                    fragment = new home();
                    toolbar.setTitle("Available Router");
                    break;
                case R.id.page_2:
                    fragment = new add_router();
                    toolbar.setTitle("Add New Router");
                    break;
                case R.id.page_3:
                    fragment = new user();
                    toolbar.setTitle("Add Users");
                    break;



            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_layout, fragment).commit();
            return true;
        }

    };
}