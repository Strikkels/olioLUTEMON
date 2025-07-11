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
        System.out.println(lutemon.getName() + " added to " + name);
        System.out.println("Lutemons currently at " + name + ": ");
        for(int key : lutemonStorage.keySet()){
            System.out.println(key + " " + lutemonStorage.get(key).getType() + "(" + lutemonStorage.get(key).getName() + ")");
        } System.out.println("");
    }

    public Lutemon yoinkLutemon(int lutemonId){
        Lutemon lutemon = lutemonStorage.remove(lutemonId);
        System.out.println("Lutemon " + lutemon.getName() + " yoinked from " + name + "!");
        return lutemon;
    }
    public String getName(){
        return name;
    }
}
