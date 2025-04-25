package com.lauri.oliolutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonTrainingViewHolder extends RecyclerView.ViewHolder {
    TextView lutemonNameTxt, lutemonTypeTxt, lutemonHpTxt ;
    ImageView lutemonImg,sendHomeBtn;
    public LutemonTrainingViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonNameTxt = itemView.findViewById(R.id.LutemonNameTxt);
        lutemonTypeTxt = itemView.findViewById(R.id.LutemonTypeTxt);
        lutemonHpTxt = itemView.findViewById(R.id.LutemonHpTxt);
        lutemonImg = itemView.findViewById(R.id.LutemonImg);
        sendHomeBtn = itemView.findViewById(R.id.LutemonTestRV);


    }
}
