package com.example.lastonetest;

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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class user extends Fragment {
    public  static EditText firstname;
    public static EditText nic;
    public static EditText address;
    public static EditText number;
    String personId;
    Button register;
    class_user UserRegister;
    DatabaseReference reff;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contectView = inflater.inflate(R.layout.user, container, false);
        FirebaseApp.initializeApp(getActivity());
        firstname = (EditText)contectView.findViewById(R.id.customer_name);
        nic = (EditText)contectView.findViewById(R.id.customer_id);
        address =  (EditText)contectView.findViewById(R.id.cusomer_address_input);
        number =(EditText)contectView.findViewById(R.id.customer_number);
        register = (Button)contectView.findViewById(R.id.button);
        reff = FirebaseDatabase.getInstance().getReference().child("customers");

        UserRegister = new class_user();
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        if (acct != null) {
            personId = acct.getId();

        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = firstname.getText().toString();
                String addre = address.getText().toString();
                String contactnum = number.getText().toString();
                String customer_id_number = nic.getText().toString();
                UserRegister.setCus_name(fname);
                UserRegister.setNic(customer_id_number);
                UserRegister.setAddress(addre);
                UserRegister.setPhonenumber(contactnum);
                UserRegister.setGoogle_id(personId);
                reff.child(customer_id_number).setValue(UserRegister);

                firstname.setText("");
                address.setText("");
                number.setText("");
                nic.setText("");
                Toast.makeText(getActivity(), "Register Success", Toast.LENGTH_LONG).show();


            }
        });

        return contectView;


    }


}
