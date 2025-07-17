package com.lauri.oliolutemon.location;

import android.util.Log;

import androidx.annotation.NonNull;

import com.lauri.oliolutemon.LutemonType;
import com.lauri.oliolutemon.monsters.Black;
import com.lauri.oliolutemon.monsters.Green;
import com.lauri.oliolutemon.monsters.Lutemon;
import com.lauri.oliolutemon.monsters.Orange;
import com.lauri.oliolutemon.monsters.Pink;
import com.lauri.oliolutemon.monsters.White;

public class Home extends LutemonLocation{
    protected static int idCounter;
    protected int lutemonId;
    public Home() {
        name = "Home";
        
    }

    public Lutemon createLutemon(LutemonType lutemonType, String lutemonName){
        Lutemon lutemon = null;
        lutemonId = idCounter;
        idCounter++;
        switch (lutemonType) {
            case BLACK:
                lutemon = new Black(lutemonName,lutemonId);
                break;
            case GREEN:
                lutemon = new Green(lutemonName,lutemonId);
                break;
            case ORANGE:
                lutemon = new Orange(lutemonName,lutemonId);
                break;
            case PINK:
                lutemon = new Pink(lutemonName,lutemonId);
                break;
            case WHITE:
                lutemon = new White(lutemonName,lutemonId);
                break;
            default:
                break;
        }
        lutemonStorage.put(lutemonId, lutemon);

        for(int key : lutemonStorage.keySet()) {
            String lName = lutemonStorage.get(key).getName();
            int lId = lutemonStorage.get(key).getId();
        }
        return lutemon;
    }
}
