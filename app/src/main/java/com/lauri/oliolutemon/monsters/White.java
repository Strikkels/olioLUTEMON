package com.lauri.oliolutemon.monsters;

import com.lauri.oliolutemon.R;

public class White extends Lutemon{
    public White(String name) {
        super(name);
        img = R.drawable.white;
        type = "White";
        attack = 5;
        defense = 4;
        experience = 1;
        maxHealth = 20;
        health = maxHealth;
    }
}
