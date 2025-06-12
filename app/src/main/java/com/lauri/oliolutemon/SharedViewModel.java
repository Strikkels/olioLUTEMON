package com.lauri.oliolutemon;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lauri.oliolutemon.monsters.Lutemon;

import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<List<Lutemon>> itemList = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Lutemon>> getItemList() {
        return itemList;
    }

    public void addItem(Lutemon lutemon) {
        List<Lutemon> currentList = itemList.getValue();
        currentList.add(lutemon);
        itemList.setValue(currentList);
    }
}
