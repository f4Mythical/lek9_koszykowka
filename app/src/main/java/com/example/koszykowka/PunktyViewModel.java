package com.example.koszykowka;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class PunktyViewModel extends ViewModel {
    private MutableLiveData<Integer>punkty;

    public MutableLiveData<Integer> getPunkty() {
        if (punkty == null){
            punkty = new MutableLiveData<>();
            punkty.setValue(0);

        }
        return punkty;
    }

    public void setPunkty(MutableLiveData<Integer> punkty) {
        if (punkty == null){
            punkty = new MutableLiveData<>();
        }
        this.punkty = punkty;
    }

    public void addPunkty(int p){
        if(punkty== null){
            punkty = new MutableLiveData<>();
        punkty.setValue(0);
        }
        int aktualnePunkty =punkty.getValue();
        punkty.setValue(aktualnePunkty+p);

    }
}
