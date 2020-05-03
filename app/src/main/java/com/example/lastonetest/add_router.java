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
    class_router routerDb;
    DatabaseReference reff;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.router_registrations,container,false);
        myedit = (EditText)rootView.findViewById(R.id.imi_number);
        simedit = (EditText)rootView.findViewById(R.id.sim_number);
        if(dashboard.imi_id != null){
            myedit.setText(dashboard.imi_id);
        }
        if(dashboard.sim_id != null){
            simedit.setText(dashboard.sim_id);
        }
        addtodb = (Button)rootView.findViewById(R.id.button3);
        date = (EditText)rootView.findViewById(R.id.stock_came) ;
        scan_router = (Button) rootView.findViewById(R.id.imi_scan);
        scan_sim = (Button)rootView.findViewById(R.id.sim_scan);
        reff = FirebaseDatabase.getInstance().getReference().child("routers");
        routerDb = new class_router();
        scan_router.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity(),scan_router_imi.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Testing", Toast.LENGTH_LONG).show();

            }
        });

        addtodb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bcode = myedit.getText().toString();
                String simcode = simedit.getText().toString();
                String dof = date.getText().toString();
                routerDb.setRouter_imi(bcode);
                routerDb.setSim_imi(simcode);
                routerDb.setDate(dof);
                reff.child(simcode).setValue(routerDb);
                myedit.setText("");
                simedit.setText("");
                date.setText("");

            }
        });

        scan_sim.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity(),scan_sim.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Please Scan the Sim", Toast.LENGTH_LONG).show();

            }
        });
        return rootView;
    }
}
