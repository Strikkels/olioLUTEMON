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
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    public HomeRecyclerViewAdapter(Context context, HashMap<Integer, Lutemon> lutemonStorage) {
        this.context = context;
        for(int key : lutemonStorage.keySet()) {
            String lName = lutemonStorage.get(key).getName();

        }
    }

    @NonNull
    @Override
    public HomeRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_home_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
