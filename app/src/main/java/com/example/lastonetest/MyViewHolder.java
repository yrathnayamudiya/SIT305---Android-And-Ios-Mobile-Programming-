package com.example.lastonetest;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView id,sim,date;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.name);
        sim = itemView.findViewById(R.id.sim);
        date = itemView.findViewById(R.id.date);

    }
}
