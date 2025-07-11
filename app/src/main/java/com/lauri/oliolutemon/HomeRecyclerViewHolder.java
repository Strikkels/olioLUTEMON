package com.lauri.oliolutemon;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView lutemonNameTxt, lutemonTypeTxt, lutemonHealthTxt;
    public HomeRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonTypeTxt = itemView.findViewById(R.id.LutemonTypeTxt);
        lutemonNameTxt = itemView.findViewById(R.id.LutemonNameTxt);
        lutemonHealthTxt = itemView.findViewById(R.id.LutemonHpTxt);
    }
}
