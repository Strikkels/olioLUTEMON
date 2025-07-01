package com.lauri.oliolutemon.monsters;

import com.lauri.oliolutemon.R;

public class Black extends Lutemon {
    public Black(String name) {
        super(name);
        img = R.drawable.black;
        type = "Black";
        attack = 9;
        defense = 0;
        experience = 1;
        maxHealth = 16;
        health = maxHealth;

    }
}
