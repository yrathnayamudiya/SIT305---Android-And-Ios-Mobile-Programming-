package com.example.lastonetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_router extends Fragment {
    private View rootView;
    public static EditText myedit;
    public static  EditText simedit;
    public static  EditText date;
    Button scan_router,scan_sim,addtodb;

    DatabaseReference reff;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.router_registrations,container,false);

        return rootView;
    }
}
