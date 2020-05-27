package com.example.lastonetest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class view extends Fragment {
    String uid = "";
    Button serch;
    TextView datev;
    EditText search;
    TextView imi_routerv;
    TextView sim_imiv;
    View contectView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contectView= inflater.inflate(R.layout.view,container,false);
        search = (EditText)contectView.findViewById(R.id.phonenumber);
        datev = (TextView)contectView.findViewById(R.id.date);
        imi_routerv = (TextView)contectView.findViewById(R.id.router_imi);
        sim_imiv =(TextView)contectView.findViewById(R.id.sim_imi);
        serch = contectView.findViewById(R.id.button2);
        final ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String date = dataSnapshot.child("date").getValue(String.class);
                String sim = dataSnapshot.child("sim_imi").getValue(String.class);
                String router_imi = dataSnapshot.child("router_imi").getValue(String.class);
                datev.setText(date);
                imi_routerv.setText(router_imi);
                sim_imiv.setText(sim);
                Toast.makeText(getActivity(),date,Toast.LENGTH_LONG).show();
                Log.d("TAG", date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("TAG", databaseError.getMessage()); //Don't ignore errors!
            }
        };
        serch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uid = search.getText().toString();
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                DatabaseReference uidRef = rootRef.child("routers").child(uid);
                uidRef.addListenerForSingleValueEvent(valueEventListener);
            }
        });




        return contectView;
    }
}
