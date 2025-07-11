package com.lauri.oliolutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemonsToDisplay = new ArrayList<>();
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
        //holder.lutemonHealthTxt.setText(lutemonsToDisplay.get(position).getHealth());
    }

    @Override
    public int getItemCount() {
        return lutemonsToDisplay.size();
    }
}
