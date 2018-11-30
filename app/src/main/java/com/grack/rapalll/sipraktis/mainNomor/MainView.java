package com.grack.rapalll.sipraktis.mainNomor;

import com.grack.rapalll.sipraktis.model.Dosen;

import java.util.List;

public interface MainView {
    void showLoading();
    void hideLoading();
    void showDosen(List<Dosen> dosenList);
}
