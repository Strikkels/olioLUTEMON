package com.lauri.oliolutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;

public class LutemonsListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonsListAdapter(ArrayList<Lutemon> lutemons){
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.lutemonNameTxt.setText(lutemons.get(position).getName());
        holder.lutemonTypeTxt.setText(lutemons.get(position).getType());
        holder.lutemonImg.setImageResource(lutemons.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return LutemonStorage.getInstance().getLutemons().size();
    }
}
