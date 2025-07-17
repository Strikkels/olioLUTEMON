package com.lauri.oliolutemon.location;

public class TrainingArea extends LutemonLocation{
    public TrainingArea() {
        name = "Training Area";
    }

    public void trainLutemons(){
        int xp = 0;
        for(int key : lutemonStorage.keySet()){
            xp = ((int) (Math.random() * 10)) + 1;
            lutemonStorage.get(key).gainExperience(xp);
        }
    }
}