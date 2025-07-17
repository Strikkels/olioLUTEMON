package com.lauri.oliolutemon.monsters;

import com.lauri.oliolutemon.R;

public class Orange extends Lutemon{
    public Orange(String name, int id) {
        super(name, id);
        img = R.drawable.lutemon_orange_icon;
        type = "Orange";
        attack = 8;
        defense = 1;
        experience = 1;
        maxHealth = 17;
        health = maxHealth;
    }
}
