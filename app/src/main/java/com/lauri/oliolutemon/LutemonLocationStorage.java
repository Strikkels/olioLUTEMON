package com.lauri.oliolutemon;

import com.lauri.oliolutemon.location.BattleArena;
import com.lauri.oliolutemon.location.Home;
import com.lauri.oliolutemon.location.TrainingArea;

public class LutemonLocationStorage {
    private static LutemonLocationStorage lutemonLocationStorage = null;
    private Home home = new Home();
    private BattleArena battleArena = new BattleArena();
    private TrainingArea trainingArea = new TrainingArea();
    private LutemonLocationStorage(){
    }
    public static LutemonLocationStorage getInstance(){
        if(lutemonLocationStorage == null){
            lutemonLocationStorage = new LutemonLocationStorage();
        }
        return lutemonLocationStorage;
    }
    public Home getHome(){
        return home;
    }

    public BattleArena getBattleArena() {
        return battleArena;
    }

    public TrainingArea getTrainingArea() {
        return trainingArea;
    }
}
