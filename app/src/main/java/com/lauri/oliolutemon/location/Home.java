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
        lutemonStorage.put(lutemonId, new Black("Metal"));
        lutemonId = idCounter;
        idCounter++;
        lutemonStorage.put(lutemonId, new Green("Gröna"));
        lutemonId = idCounter;
        idCounter++;
        lutemonStorage.put(lutemonId, new Orange("Orinz"));
        lutemonId = idCounter;
        idCounter++;
        lutemonStorage.put(lutemonId, new Pink("Possu"));
        lutemonId = idCounter;
        idCounter++;
        lutemonStorage.put(lutemonId, new White("Mr"));
        lutemonId = idCounter;
        idCounter++;
    }

    public Lutemon createLutemon(LutemonType lutemonType, String lutemonName){
        Lutemon lutemon = null;
        switch (lutemonType) {
            case BLACK:
                lutemon = new Black(lutemonName);
                break;
            case GREEN:
                lutemon = new Green(lutemonName);
                break;
            case ORANGE:
                lutemon = new Orange(lutemonName);
                break;
            case PINK:
                lutemon = new Pink(lutemonName);
                break;
            case WHITE:
                lutemon = new White(lutemonName);
                break;
            default:
                System.out.println("Invalid lutemon type");
                break;
        }
        lutemonId = idCounter;
        idCounter++;
        lutemonStorage.put(lutemonId, lutemon);

        System.out.println("Lutemon created!" + " Lutemons at Home: ");
        for(int key : lutemonStorage.keySet()) {
            String lName = lutemonStorage.get(key).getName();
            Log.d("LUTEMONS",key + " " + lName);
        }
        return lutemon;
    }
}
