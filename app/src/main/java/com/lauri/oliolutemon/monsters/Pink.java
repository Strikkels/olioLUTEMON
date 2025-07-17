package com.lauri.oliolutemon.monsters;

import com.lauri.oliolutemon.R;

public class Pink extends Lutemon{
    public Pink(String name, int id) {
        super(name, id);
        img = R.drawable.lutemon_pink_icon;
        type = "Pink";
        attack = 7;
        defense = 2;
        experience = 1;
        maxHealth = 18;
        health = maxHealth;
    }
}
