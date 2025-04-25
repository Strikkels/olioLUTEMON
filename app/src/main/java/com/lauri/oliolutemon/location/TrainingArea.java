package com.lauri.oliolutemon.location;

import com.lauri.oliolutemon.LutemonStorage;
import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;

public class TrainingArea extends LutemonLocation{
    public TrainingArea() {
        name = "Training Area";
    }

    public void train(int Id){
        ArrayList<Lutemon> homeLutemons = LutemonStorage.getInstance().getHome().getLutemons();
        for(Lutemon l : homeLutemons){
            if(l.getId() == Id){
                lutemons.add(l);
                LutemonStorage.getInstance().getHome().removeLutemon(l.getId());
            }
            else{

            }
        }
    }
}
