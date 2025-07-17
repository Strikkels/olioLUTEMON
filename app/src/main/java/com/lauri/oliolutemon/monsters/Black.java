package com.lauri.oliolutemon.monsters;

import com.lauri.oliolutemon.R;

public class Black extends Lutemon {
    public Black(String name, int id) {
        super(name, id);
        img = R.drawable.lutemon_black_icon;
        type = "Black";
        attack = 9;
        defense = 0;
        experience = 1;
        maxHealth = 16;
        health = maxHealth;


    }
}
