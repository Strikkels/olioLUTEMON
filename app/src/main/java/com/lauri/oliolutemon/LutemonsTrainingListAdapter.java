package com.lauri.oliolutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;

public class LutemonsTrainingListAdapter extends RecyclerView.Adapter<LutemonTrainingViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonsTrainingListAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.lutemons = lutemons;
        this.context = context;
    }

    @NonNull
    @Override
    public LutemonTrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonTrainingViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_training_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonTrainingViewHolder holder, int position) {
        holder.lutemonNameTxt.setText(lutemons.get(position).getName());
        holder.lutemonTypeTxt.setText(lutemons.get(position).getType());
        holder.lutemonImg.setImageResource(lutemons.get(position).getImg());

        holder.sendHomeBtn.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            lutemons = LutemonStorage.getInstance().getTrainingArea().sendHome(lutemons.get(pos).getId());
            notifyItemRemoved(pos);

        });
    }

    @Override
    public int getItemCount() {
        return LutemonStorage.getInstance().getTrainingArea().getLutemons().size();
    }
}
