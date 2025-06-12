package com.lauri.oliolutemon;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;

public class LutemonsHomeListAdapter extends RecyclerView.Adapter<LutemonHomeViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonsHomeListAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.lutemons = lutemons;
        this.context = context;
    }

    @NonNull
    @Override
    public LutemonHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonHomeViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_home_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonHomeViewHolder holder, int position) {
        holder.lutemonNameTxt.setText(lutemons.get(position).getName());
        holder.lutemonTypeTxt.setText(lutemons.get(position).getType());
        holder.lutemonImg.setImageResource(lutemons.get(position).getImg());

        holder.lutemonSendTrainingImg.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            LutemonStorage.getInstance().getTrainingArea().train(lutemons.get(pos));
            LutemonStorage.getInstance().getHome().removeLutemon(lutemons.get(pos).getId());
            notifyItemRemoved(pos);
        });
    }

    @Override
    public int getItemCount() {
        return LutemonStorage.getInstance().getHome().getLutemons().size();
    }
}
