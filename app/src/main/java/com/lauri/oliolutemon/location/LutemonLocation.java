package com.lauri.oliolutemon.location;

import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;
import java.util.HashMap;

public class LutemonLocation {
    protected HashMap<Integer, Lutemon> lutemonStorage = new HashMap<>();
    protected String name;
    public LutemonLocation() {
    }
    public HashMap<Integer, Lutemon> getLutemons() {
        return lutemonStorage;
    }


    public void addLutemon(int lutemonId, Lutemon lutemon){
        lutemonStorage.put(lutemonId, lutemon);
    }

    public Lutemon yoinkLutemon(int lutemonId){
        Lutemon lutemon = lutemonStorage.remove(lutemonId);
        return lutemon;
    }
    public String getName(){
        return name;
    }
}
