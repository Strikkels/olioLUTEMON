package com.lauri.oliolutemon.location;

import com.lauri.oliolutemon.monsters.Lutemon;

public class BattleArena extends LutemonLocation{
    public BattleArena(){
        name = "BattleArena";
    }

    public void Battle(){
        //initialize lutemons
        Lutemon lutemonA = null, lutemonB = null, attacker = null, defender = null;
        int keyA = 0, keyB = 0, keyAttacker, keyDefender;
        int i = 0;
        for(int key : lutemonStorage.keySet()){
            if(i == 0){
                lutemonA = lutemonStorage.get(key);
                keyA = key;
            }
            else{
                lutemonB = lutemonStorage.get(key);
                keyB = key;
            }
            i++;
        }
        Double coinToss = Math.random() * 10;
        //Choose which lutemon starts
        if(coinToss > 5){
            attacker = lutemonA;
            defender = lutemonB;
            keyAttacker = keyA;
            keyDefender = keyB;
        } else{
            attacker = lutemonB;
            defender = lutemonA;
            keyAttacker = keyB;
            keyDefender = keyA;
        }
        System.out.println("Battle starts!");
        boolean exit = false;
        while(!exit) {
            System.out.println("Lutemons stats: ");
            for (int key : lutemonStorage.keySet()){
                lutemonStorage.get(key).printStats();
            } System.out.println("");

            //A attacks
            defender.defend(attacker.attack());
            if(defender.getHealth() > 0){
                System.out.println(defender.getName() + " managed to live!");
                lutemonStorage.replace(keyAttacker, attacker);
                lutemonStorage.replace(keyDefender, defender);
                attacker = lutemonStorage.get(keyDefender);
                defender = lutemonStorage.get(keyAttacker);
                if(keyAttacker == keyA){
                    keyAttacker = keyB;
                    keyDefender = keyA;
                } else{
                    keyAttacker = keyA;
                    keyDefender = keyB;
                }
            } else{
                System.out.println(defender.getName() + " died! " + attacker.getName() + " gained 1 xp!");
                attacker.gainHealth(attacker.getMaxHealth());
                defender.gainHealth(defender.getMaxHealth());
                attacker.gainExperience(1);
                lutemonStorage.replace(keyAttacker, attacker);
                lutemonStorage.replace(keyDefender, defender);
                exit = true;
            }
        }

        lutemonStorage.replace(keyA, lutemonA);
        lutemonStorage.replace(keyB, lutemonB);
    }
}

