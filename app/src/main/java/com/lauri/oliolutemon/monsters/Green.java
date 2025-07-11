package com.lauri.oliolutemon.monsters;

import com.lauri.oliolutemon.R;

public class Green extends Lutemon{
    public Green(String name) {
        super(name);
        //img = R.drawable.Green;
        type = "Green";
        attack = 6;
        defense = 3;
        experience = 1;
        maxHealth = 19;
        health = maxHealth;
    }
}
