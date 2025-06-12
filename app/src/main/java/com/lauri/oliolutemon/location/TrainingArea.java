package com.lauri.oliolutemon.location;

import android.util.Log;

import com.lauri.oliolutemon.LutemonStorage;
import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;

public class TrainingArea extends LutemonLocation{
    public TrainingArea() {
        name = "Training Area";
    }

    public void train(Lutemon lutemon){
        lutemons.add(lutemon);
        Log.d("training area", "Moneja: " + lutemons.size());
    }
    public ArrayList<Lutemon> sendHome(int lutemonId){
        int i = 0;
        for (Lutemon l : lutemons){
            if(l.getId() == (lutemonId)){
                break;
            }
            i++;
        }
        LutemonStorage.getInstance().getHome().recieveLutemon(lutemons.get(i));
        lutemons.remove(i);
        return lutemons;
    }
}
