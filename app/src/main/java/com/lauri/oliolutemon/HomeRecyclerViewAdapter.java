package com.lauri.oliolutemon;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lauri.oliolutemon.location.BattleArena;
import com.lauri.oliolutemon.location.Home;
import com.lauri.oliolutemon.location.TrainingArea;
import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemonsToDisplay = new ArrayList<>();
    private Home home = LocationStorage.getInstance().getHome();
    private TrainingArea trainingArea = LocationStorage.getInstance().getTrainingArea();
    private BattleArena battleArena = LocationStorage.getInstance().getBattleArena();
    public HomeRecyclerViewAdapter(Context context, HashMap<Integer, Lutemon> lutemonStorage) {
        this.context = context;
        lutemonsToDisplay.clear();
        for(int key : lutemonStorage.keySet()) {
            Lutemon l = lutemonStorage.get(key);
            lutemonsToDisplay.add(l);
        }

    }

    public void addToLutemonsToDisplay(Lutemon lutemon){
        lutemonsToDisplay.add(lutemon);
    }

    @NonNull
    @Override
    public HomeRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_home_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerViewHolder holder, int position) {
        holder.lutemonTypeTxt.setText(lutemonsToDisplay.get(position).getType());
        holder.lutemonNameTxt.setText(lutemonsToDisplay.get(position).getName());
        String health = String.valueOf(lutemonsToDisplay.get(position).getHealth());
        holder.lutemonHealthTxt.setText("Max health: " + health);
        holder.lutemonIcon.setImageResource(lutemonsToDisplay.get(position).getImg());


        holder.sendTraining.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            int lutemonId = lutemonsToDisplay.remove(pos).getId();
            Lutemon lutemon = home.yoinkLutemon(lutemonId);
            trainingArea.addLutemon(lutemonId, lutemon);
            notifyItemRemoved(pos);
        });

        holder.sendBattle.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            if(battleArena.getLutemons().size()==2){
                Toast.makeText(v.getContext(), "Battle Arena is full", Toast.LENGTH_LONG).show();
                return;
            }
            int lutemonId = lutemonsToDisplay.remove(pos).getId();
            Lutemon lutemon = home.yoinkLutemon(lutemonId);
            battleArena.addLutemon(lutemonId, lutemon);
            notifyItemRemoved(pos);
        });
    }

    @Override
    public int getItemCount() {
        return lutemonsToDisplay.size();
    }
}
