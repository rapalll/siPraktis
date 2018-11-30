package com.grack.rapalll.sipraktis.mainNomor;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.grack.rapalll.sipraktis.AdapterDosen;
import com.grack.rapalll.sipraktis.R;
import com.grack.rapalll.sipraktis.model.Dosen;

import java.util.ArrayList;
import java.util.List;

public class ContactDosenActivity extends AppCompatActivity implements MainView {


    private RecyclerView recyclerView;
    private AdapterDosen adapterDosen;
    private List<Dosen> dosenList = new ArrayList<>();
    private ProgressDialog progressDialog;
    private MainPresenterImp presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telpon);

        recyclerView = findViewById(R.id.rv_nomor);
        progressDialog = new ProgressDialog(this);
        presenter = new MainPresenterImp(this);
        presenter.loadNomor();
        setupData();

    }
    private void setupData() {
        adapterDosen = new AdapterDosen(dosenList, ContactDosenActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterDosen);
        adapterDosen.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
            progressDialog.setMessage(getResources().getString(R.string.loading));
            progressDialog.setCancelable(true);
            progressDialog.show();
        }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();

    }

    @Override
    public void showDosen(List<Dosen> listDosen) {
        dosenList.clear();
        dosenList.addAll(listDosen);
        adapterDosen.notifyDataSetChanged();

    }
}
