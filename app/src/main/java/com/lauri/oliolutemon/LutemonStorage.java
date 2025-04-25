package com.lauri.oliolutemon;

import com.lauri.oliolutemon.location.BattleField;
import com.lauri.oliolutemon.location.Home;
import com.lauri.oliolutemon.location.LutemonLocation;
import com.lauri.oliolutemon.location.TrainingArea;
import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;

public class LutemonStorage {
    private static LutemonStorage lutemonStorage = null;
    private Home home = new Home();
    private BattleField battleField = new BattleField();
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

    public BattleField getBattleField() {
        return battleField;
    }

    public TrainingArea getTrainingArea() {
        return trainingArea;
    }
}
