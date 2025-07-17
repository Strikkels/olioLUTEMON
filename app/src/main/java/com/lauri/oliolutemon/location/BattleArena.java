package com.lauri.oliolutemon.location;

import android.util.Log;

import com.lauri.oliolutemon.monsters.Lutemon;

public class BattleArena extends LutemonLocation{
    public BattleArena(){
        name = "BattleArena";
    }

    public String battle(){
        if(lutemonStorage.size()<2){
            Log.d("Lutemon Battle", "Not enough lutemons to fight");
            return "Not enough lutemons to battle";
        }
        String battleOutput = "";

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
        battleOutput += "Battle starts! \n";
        Log.d("Battle", "Battle starts!");
        boolean exit = false;
        while(!exit) {
            battleOutput += ("Lutemons stats: \n");
            for (int key : lutemonStorage.keySet()){
                String lutemonStats;
                lutemonStats = lutemonStorage.get(key).printStats();
                battleOutput += lutemonStats + "\n";
            }

            //Lutemon A and B attack and switch turns
            battleOutput += attacker.getType() + "(" + attacker.getName() + ")" + " attacks " + defender.getType() + "(" + defender.getName() + ") ";
            defender.defend(attacker.attack());
            if(defender.getHealth() > 0){
                battleOutput += (defender.getName() + " managed to live!\n");
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
                battleOutput += (defender.getName() + " died! " + attacker.getName() + " gained 1 xp!");
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

        return battleOutput;
    }
}

