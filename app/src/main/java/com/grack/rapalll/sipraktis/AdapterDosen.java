package com.grack.rapalll.sipraktis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
  public void onBindViewHolder(@NonNull final HolderDosen holder,
      @SuppressLint("RecyclerView") final int position) {
    final Dosen holderDosen = mDosen.get(position);

    holder.nama_dosen.setText(holderDosen.getNamaDosen());
    holder.no_dosen.setText(String.valueOf(holderDosen.getNoDosen()));

    holder.itemView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

        String uri = "tel:" + String.valueOf(holderDosen.getNoDosen());
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        context.startActivity(intent);

//                Toast.makeText(context, , Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public int getItemCount() {
    return mDosen.size();
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


