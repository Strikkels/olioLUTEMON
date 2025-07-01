package com.lauri.oliolutemon;

import com.lauri.oliolutemon.location.BattleArena;
import com.lauri.oliolutemon.location.Home;
import com.lauri.oliolutemon.location.TrainingArea;

public class LutemonStorage {
    private static LutemonStorage lutemonStorage = null;
    private Home home = new Home();
    private BattleArena battleArena = new BattleArena();
    private TrainingArea trainingArea = new TrainingArea();
    private LutemonStorage(){
    }
    public static LutemonStorage getInstance(){
        if(lutemonStorage == null){
            lutemonStorage = new LutemonStorage();
        }
        return lutemonStorage;
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
