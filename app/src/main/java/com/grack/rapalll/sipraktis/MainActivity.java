package com.grack.rapalll.sipraktis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.grack.rapalll.sipraktis.mainNomor.ContactDosenActivity;
import com.grack.rapalll.sipraktis.model.Dosen;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Dosen> mDosen;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButton = (ImageButton) findViewById(R.id.btn_dikti);

    }
    public void simbelmawa(View view){
        Intent i = new Intent(MainActivity.this, SimbelmawaWebView.class);
        startActivity(i);

    }
    public void skripsi (View view){
        Intent skripsi = new Intent(MainActivity.this, ContactDosenActivity.class);
        startActivity(skripsi);
    }

    public void pakar (View view){
        Intent pakar = new Intent(MainActivity.this, DetailSkripsi.class);
        startActivity(pakar);
//        Dosen data = mDosen.get(position);
//        Intent intent = new Intent(context, DetailSkripsi.class);
//        intent.putExtra("detail_makanan", new GsonBuilder().create().toJson(data));
    }
}
