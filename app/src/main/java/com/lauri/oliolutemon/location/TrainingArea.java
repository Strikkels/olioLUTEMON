package com.lauri.oliolutemon.location;

import android.util.Log;

import com.lauri.oliolutemon.LutemonStorage;
import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;

public class TrainingArea extends LutemonLocation{
    public TrainingArea() {
        name = "Training Area";
    }

    public void trainLutemons(){
        int xp = 0;
        for(int key : lutemonStorage.keySet()){
            xp = (int) (Math.random() * 100);
            lutemonStorage.get(key).gainExperience(xp);
            System.out.println(lutemonStorage.get(key).getName() + " gained " + xp + " experience!");
        }
    }
}