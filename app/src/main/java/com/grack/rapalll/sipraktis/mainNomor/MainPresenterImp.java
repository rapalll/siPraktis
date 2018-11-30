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
    private DatabaseReference mRef;
    private String namaDosen, noDosen, imgSkripsi;
    private int idDosen;
    private List<Dosen> mDosen;

    MainPresenterImp(MainView view) {
        this.view = view;
    }


    @Override
    public void loadNomor() {
        view.showLoading();
        mRef= FirebaseDatabase.getInstance().getReference().child("test");
        final Query asc = mRef.orderByChild("namaDosen");
        asc.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mDosen = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Dosen value = dataSnapshot1.getValue(Dosen.class);
                    mDosen.add(value);
                    Dosen fire = new Dosen();

                    idDosen = value != null ? value.getIdDosen() : 0;
                    namaDosen = value != null ? value.getNameDosen() : null;
//                    imgSkripsi = value != null ? value.getImgSkripsi() : null;
                    noDosen = value != null ? value.getNoDosen() : null;


//
                    fire.setIdDosen(idDosen);
                    fire.setNameDosen(namaDosen);
                    fire.setNoDosen(noDosen);
//                    fire.setImgSkripsi(imgSkripsi);


                    mDosen.add(fire);
                    view.showDosen(mDosen);
                }

                view.hideLoading();
                mRef.keepSynced(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Firebase: ", "failed to read value.", databaseError.toException());
            }
        });
    }
}