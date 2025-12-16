package com.example.koszykowka;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PunktyViewModel extends ViewModel {
    private MutableLiveData<Integer> punktyGracz1;
    private MutableLiveData<Integer> punktyGracz2;

    public MutableLiveData<Integer> getPunktyGracz1() {
        if (punktyGracz1 == null) {
            punktyGracz1 = new MutableLiveData<>();
            punktyGracz1.setValue(0);
        }
        return punktyGracz1;
    }

    public MutableLiveData<Integer> getPunktyGracz2() {
        if (punktyGracz2 == null) {
            punktyGracz2 = new MutableLiveData<>();
            punktyGracz2.setValue(0);
        }
        return punktyGracz2;
    }

    public void addPunktyGracza(int gracz, int p) {
        if (gracz == 1) {
            MutableLiveData<Integer> ld = getPunktyGracz1();
            Integer curr = ld.getValue();
            if (curr == null) {
                curr = 0;
            }
            ld.setValue(curr + p);
        } else {
            MutableLiveData<Integer> ld = getPunktyGracz2();
            Integer curr = ld.getValue();
            if (curr == null) {
                curr = 0;
            }
            ld.setValue(curr + p);
        }
    }
}