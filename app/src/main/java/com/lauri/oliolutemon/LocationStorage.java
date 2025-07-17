package com.lauri.oliolutemon;

import com.lauri.oliolutemon.location.BattleArena;
import com.lauri.oliolutemon.location.Home;
import com.lauri.oliolutemon.location.TrainingArea;

public class LocationStorage {
    private static LocationStorage locationStorage = null;
    private Home home = new Home();
    private BattleArena battleArena = new BattleArena();
    private TrainingArea trainingArea = new TrainingArea();
    private LocationStorage(){
    }
    public static LocationStorage getInstance(){
        if(locationStorage == null){
            locationStorage = new LocationStorage();
        }
        return locationStorage;
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
