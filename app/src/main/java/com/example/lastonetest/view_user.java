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

public class view_user extends Fragment {
    String uid = "";
    Button serch;
    TextView name;
    EditText search;
    TextView nic;
    TextView address;
    TextView phone;
    View contectView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contectView= inflater.inflate(R.layout.view_user,container,false);
        search = (EditText)contectView.findViewById(R.id.phonenumber);
        name = (TextView)contectView.findViewById(R.id.name);
        address =(TextView)contectView.findViewById(R.id.address);
        phone =(TextView)contectView.findViewById(R.id.telnu);
        serch = contectView.findViewById(R.id.button2);
        final ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String va_address = dataSnapshot.child("address").getValue(String.class);
                String v_name = dataSnapshot.child("cus_name").getValue(String.class);
                String v_nic = dataSnapshot.child("nic").getValue(String.class);
                String v_phone = dataSnapshot.child("phonenumber").getValue(String.class);
                name.setText(v_name);
                address.setText(va_address);
                nic.setText(v_nic);
                phone.setText(v_phone);
                Toast.makeText(getActivity(),"Inserting Data To Database is Success",Toast.LENGTH_LONG).show();

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
                DatabaseReference uidRef = rootRef.child("customers").child(uid);
                uidRef.addListenerForSingleValueEvent(valueEventListener);
            }
        });




        return contectView;
    }
}
