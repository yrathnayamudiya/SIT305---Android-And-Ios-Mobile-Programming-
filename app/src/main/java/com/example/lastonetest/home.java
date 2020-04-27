package com.example.lastonetest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class home extends Fragment {
    private View contectView;
    private RecyclerView mycontec;
    private DatabaseReference ref;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contectView= inflater.inflate(R.layout.home,container,false);
        mycontec =(RecyclerView)contectView.findViewById(R.id.recycle);
        mycontec.setLayoutManager(new LinearLayoutManager(getContext()));
        ref = FirebaseDatabase.getInstance().getReference().child("routers");
          return contectView;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerOptions option =
                new FirebaseRecyclerOptions.Builder<productsModal>().setQuery(ref,productsModal.class).build();
        FirebaseRecyclerAdapter<productsModal,MyViewHolder> adapter = new FirebaseRecyclerAdapter<productsModal, MyViewHolder>(option) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull productsModal model) {
                holder.id.setText(model.getRouter_imi());
                holder.sim.setText(model.getSim_imi());
                holder.date.setText(model.getDate());


            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
                MyViewHolder myViewHolder = new MyViewHolder(view);
                return myViewHolder;
            }
        };

        adapter.startListening();
        mycontec.setAdapter(adapter);
    }
}
