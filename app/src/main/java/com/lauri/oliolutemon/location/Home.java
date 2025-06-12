package com.lauri.oliolutemon.location;

import com.lauri.oliolutemon.monsters.Lutemon;

public class Home extends LutemonLocation{
    public Home() {
        name = "Home";

    }

    public void createLutemon(Lutemon lutemon){
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

    public void recieveLutemon(Lutemon lutemon){
        lutemons.add(lutemon);
    }
}
