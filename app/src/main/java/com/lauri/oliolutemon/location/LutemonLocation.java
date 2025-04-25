package com.lauri.oliolutemon.location;

import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;

public class LutemonLocation {
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();
    protected String name;
    public LutemonLocation() {
    }
    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }


}
