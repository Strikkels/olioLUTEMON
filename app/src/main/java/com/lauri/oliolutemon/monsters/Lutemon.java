package com.lauri.oliolutemon.monsters;

import android.util.Log;

public class Lutemon {
    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected String type;
    protected int img;
    protected int id;


    public Lutemon(String name,int attack, int defense, int experience, int health, int maxHealth, int id){
        this.maxHealth = maxHealth;
        this.name = name;
        this.id = id;

    }
    public Lutemon (String name, int id){
        this.maxHealth = 0;
        this.name = name;
        this.id = id;
    }
    public void defend(int damage){
        int takenDamage;
        if(damage > defense){
            takenDamage = damage - defense;
            health -= takenDamage;
        } else{
            takenDamage = 0;
        }
    }
    public int attack(){
        attack += (int) (Math.random() * 10);
        return attack;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getType() {
        return type;
    }

    public int getImg() {
        return img;
    }
    public int getId(){ return id; }
    public void gainExperience(int experience) {
        this.experience += experience;
        this.maxHealth += experience;
        this.health = maxHealth;
        this.defense += experience;
        this.attack += experience;
    }

    public void gainHealth(int health){
        this.health += health;
    }

    public String getStats(){
        String stats = type + " (" + name + ")" + " att: " + attack + ", def: " + defense + " exp: " + experience + "; healt: " + health + "/" + maxHealth;
        return stats;
    }
}
