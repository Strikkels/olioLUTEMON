package com.lauri.oliolutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrainingAreaRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView lutemonNameTxt, lutemonTypeTxt, lutemonHealthTxt, lutemonXpTxt;
    ImageView lutemonIcon, sendHomeBtn;
    public TrainingAreaRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonTypeTxt = itemView.findViewById(R.id.LutemonTrainingTypeTxt);
        lutemonNameTxt = itemView.findViewById(R.id.LutemonTrainingNameTxt);
        lutemonHealthTxt = itemView.findViewById(R.id.LutemonTrainingHealthTxt);
        lutemonXpTxt = itemView.findViewById(R.id.LutemonXpTxt);
        lutemonIcon = itemView.findViewById(R.id.LutemonImg);
        sendHomeBtn = itemView.findViewById(R.id.SendHomeBtn);
    }
}
