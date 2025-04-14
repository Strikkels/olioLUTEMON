package com.lauri.oliolutemon.monsters;

public class Lutemon {
    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected static int idCounter = 0;

    public Lutemon(String name,int attack, int defense, int experience, int health, int maxHealth, int id){
        this.name = name;
        this.id = idCounter;
        idCounter++;
    }
    public Lutemon (String name){
        this.name = name;

    }
    public void defense(Lutemon lutemon){

    }
    public void attack(){

    }
    public int getNumberOfCreatedLutemons(){
        return ++idCounter;
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

    public int getId() {
        return id;
    }
}
