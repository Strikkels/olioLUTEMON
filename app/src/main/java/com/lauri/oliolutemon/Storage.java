package com.lauri.oliolutemon;

import java.util.ArrayList;

public class Storage {
    private String name;
    private ArrayList<Lutemon> lutemons; //Voisi kokeilla myös Hashmappiä

    public Storage(String name, ArrayList<Lutemon> lutemons) {
        this.name = name;
        this.lutemons = lutemons;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public String getName() {
        return name;
    }
}
