package com.lauri.oliolutemon;

import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;

public class LutemonStorage {
    private static LutemonStorage lutemonStorage = null;
    private ArrayList<Lutemon> lutemons; //Voisi kokeilla myös Hashmappiä
    private LutemonStorage(){
    }
    public static LutemonStorage getInstance(){
        if(lutemonStorage == null){
            lutemonStorage = new LutemonStorage();
        }
        return lutemonStorage;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
    public void addLutemon(Lutemon lutemon){
        lutemons.add(lutemon);
    }
    public void removeLutemon(int lutemonId){
        int i = 0;
        for (Lutemon l : lutemons){
            if(l.getId() == (lutemonId)){
                break;
            }
            i++;
        }
        lutemons.remove(i);
    }
}
