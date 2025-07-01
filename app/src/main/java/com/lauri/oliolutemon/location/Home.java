package com.lauri.oliolutemon.location;

import com.lauri.oliolutemon.monsters.Black;
import com.lauri.oliolutemon.monsters.Green;
import com.lauri.oliolutemon.monsters.Lutemon;
import com.lauri.oliolutemon.monsters.Orange;
import com.lauri.oliolutemon.monsters.Pink;
import com.lauri.oliolutemon.monsters.White;

public class Home extends LutemonLocation{
    protected static int idCounter;
    protected int lutemonId;
    public Home() {
        name = "Home";
        lutemonStorage.put(lutemonId, new Black("Metal"));
        lutemonId = idCounter;
        idCounter++;
        lutemonStorage.put(lutemonId, new Green("Gröna"));
        lutemonId = idCounter;
        idCounter++;
        lutemonStorage.put(lutemonId, new Orange("Orinz"));
        lutemonId = idCounter;
        idCounter++;
        lutemonStorage.put(lutemonId, new Pink("Possu"));
        lutemonId = idCounter;
        idCounter++;
        lutemonStorage.put(lutemonId, new White("Mr"));
        lutemonId = idCounter;
        idCounter++;
    }

    public void createLutemon(int lutemonType, String lutemonName){
        Lutemon lutemon = null;
        switch (lutemonType) {
            case 1:
                lutemon = new Black(lutemonName);
                break;
            case 2:
                lutemon = new Green(lutemonName);
                break;
            case 3:
                lutemon = new Orange(lutemonName);
                break;
            case 4:
                lutemon = new Pink(lutemonName);
                break;
            case 5:
                lutemon = new White(lutemonName);
                break;
            default:
                System.out.println("Not an option, try between 1-5");
                break;
        }
        lutemonId = idCounter;
        idCounter++;
        lutemonStorage.put(lutemonId, lutemon);

        System.out.println("Lutemon created!" + " Lutemons at Home: ");
        for(int key : lutemonStorage.keySet()) {
            String lName = lutemonStorage.get(key).getName();
            System.out.println(key + " " + lName);
        }
        System.out.println("\n");
    }
}
