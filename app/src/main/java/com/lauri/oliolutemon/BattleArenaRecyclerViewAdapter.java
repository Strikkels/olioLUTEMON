package com.lauri.oliolutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lauri.oliolutemon.location.BattleArena;
import com.lauri.oliolutemon.location.Home;
import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;
import java.util.HashMap;

public class BattleArenaRecyclerViewAdapter extends RecyclerView.Adapter<TrainingAreaRecyclerViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemonsToDisplay = new ArrayList<>();
    private BattleArena battleArena = LocationStorage.getInstance().getBattleArena();
    private Home home = LocationStorage.getInstance().getHome();

    public BattleArenaRecyclerViewAdapter(Context context, HashMap<Integer, Lutemon> lutemonStorage) {
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

    public void sendLutemonsHome(){
        for(Lutemon l : lutemonsToDisplay){
            int lutemonId = l.getId();
            home.addLutemon(lutemonId, battleArena.yoinkLutemon(lutemonId));
        }
        lutemonsToDisplay.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrainingAreaRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrainingAreaRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_training_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingAreaRecyclerViewHolder holder, int position) {
        holder.lutemonTypeTxt.setText(lutemonsToDisplay.get(position).getType());
        holder.lutemonNameTxt.setText(lutemonsToDisplay.get(position).getName());
        holder.lutemonIcon.setImageResource(lutemonsToDisplay.get(position).getImg());
        holder.lutemonHealthTxt.setText(String.valueOf("Max Health: " + lutemonsToDisplay.get(position).getMaxHealth()));
        holder.lutemonXpTxt.setText(String.valueOf("Experience: " +lutemonsToDisplay.get(position).getExperience()));

        holder.sendHomeBtn.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            int lutemonId = lutemonsToDisplay.remove(pos).getId();
            Lutemon lutemon = battleArena.yoinkLutemon(lutemonId);
            home.addLutemon(lutemonId, lutemon);
            notifyItemRemoved(pos);
        });
    }


    @Override
    public int getItemCount() {
        return lutemonsToDisplay.size();
    }
}
