package com.lauri.oliolutemon.monsters;

import com.lauri.oliolutemon.R;

public class Green extends Lutemon{
    public Green(String name, int id) {
        super(name, id);
        img = R.drawable.lutemon_green_icon;
        type = "Green";
        attack = 6;
        defense = 3;
        experience = 1;
        maxHealth = 19;
        health = maxHealth;
    }
}
