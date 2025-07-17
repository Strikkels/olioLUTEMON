package com.lauri.oliolutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView lutemonNameTxt, lutemonTypeTxt, lutemonHealthTxt, lutemonXpTxt;
    ImageView lutemonIcon, sendTraining, sendBattle;
    public HomeRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonIcon = itemView.findViewById(R.id.LutemonImg);
        lutemonTypeTxt = itemView.findViewById(R.id.LutemonTypeTxt);
        lutemonNameTxt = itemView.findViewById(R.id.LutemonNameTxt);
        lutemonHealthTxt = itemView.findViewById(R.id.LutemonHpTxt);
        sendTraining = itemView.findViewById(R.id.SendTrainingBtn);
        sendBattle = itemView.findViewById(R.id.SendBattleBtn);

    }
}
