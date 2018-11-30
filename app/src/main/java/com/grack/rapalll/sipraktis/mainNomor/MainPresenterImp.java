package com.grack.rapalll.sipraktis.mainNomor;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.grack.rapalll.sipraktis.model.Dosen;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImp implements MainPresenter {

    private MainView view;
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference("test");
    private String namaDosen, panduanSkripsi;
    private int noDosen;
    private List<Dosen> mDosen;

    MainPresenterImp(MainView view) {
        this.view = view;
    }


    @Override
    public void loadNomor() {
        view.showLoading();
//        database = FirebaseDatabase.getInstance().getReference().child("Telepon");
//        final Query asc = database.orderByChild("noDosen");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mDosen = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Dosen value = dataSnapshot1.getValue(Dosen.class);
                    Dosen fire = new Dosen();

                    namaDosen = value.getNamaDosen();
                    panduanSkripsi = value.getPanduanSkripsi();
                    noDosen = value.getNoDosen();

                    fire.setNamaDosen(namaDosen);
                    fire.setPanduanSkripsi(panduanSkripsi);
                    fire.setNoDosen(noDosen);
//                    fire.setImgSkripsi(imgSkripsi);


                    mDosen.add(fire);
                    view.showDosen(mDosen);
                    Log.i("DAA", ""+fire.getNamaDosen());
                }

                view.hideLoading();
                database.keepSynced(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Firebase: ", "failed to read value.", databaseError.toException());
            }
        });
    }
}