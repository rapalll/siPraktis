package com.grack.rapalll.sipraktis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grack.rapalll.sipraktis.model.Dosen;

import java.util.List;

public class AdapterDosen extends RecyclerView.Adapter<AdapterDosen.HolderDosen> {

    private List<Dosen> mDosen;
    private Context context;

    public AdapterDosen(List<Dosen> mDosen, Context context) {
        this.mDosen = mDosen;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderDosen onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_nomor, parent, false);
        return new HolderDosen(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderDosen holder,@SuppressLint("RecyclerView") final int position) {
        final Dosen holderDosen = mDosen.get(position);

        holder.nama_dosen.setText(holderDosen.getNameDosen());
        holder.no_dosen.setText(holderDosen.getNoDosen());

    }

    @Override
    public int getItemCount() {
        int arr = 0;

        try {
            if (mDosen.size() == 0) {
                return arr;
            } else {
                arr = mDosen.size();
            }
        } catch (Exception ignored) {
        }
        return arr;
    }



    class HolderDosen extends RecyclerView.ViewHolder {
        private TextView no_dosen, nama_dosen;

        HolderDosen(View itemView) {
            super(itemView);
            no_dosen = itemView.findViewById(R.id.tv_nomorDosen);
            nama_dosen = itemView.findViewById(R.id.tv_namaDosen);
//            imageViewPosterFood = itemView.findViewById(R.id.image_poster);
        }
    }
}


