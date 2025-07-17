package com.lauri.oliolutemon.location;

public class TrainingArea extends LutemonLocation{
    public TrainingArea() {
        name = "Training Area";
    }

    public void trainLutemons(){
        int xp = 0;
        for(int key : lutemonStorage.keySet()){
            xp = (int) (Math.random() * 10);
            lutemonStorage.get(key).gainExperience(xp);
            System.out.println(lutemonStorage.get(key).getName() + " gained " + xp + " experience!");
        }
    }
}