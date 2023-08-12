package com.example.bundesligamatch.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundesligamatch.R;
import com.example.bundesligamatch.activity.DetailTeamActivity;
import com.example.bundesligamatch.model.TeamsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

public class AdapterAllTeam extends RecyclerView.Adapter<AdapterAllTeam.ViewHolder> {

    Context context;
    List<TeamsItem> items;

    public AdapterAllTeam(Context context, List<TeamsItem> items) {
        this.context = context;
        this.items = items;
    }

    public void setItems(List<TeamsItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvNama.setText(items.get(position).getStrTeam());

        Picasso.with(context)
                .load(items.get(position).getStrTeamBadge())
                .resize(200,200)
                .into(holder.ivLogo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailTeamActivity.class);
                Bundle mBundle=new Bundle();
                mBundle.putString("id",items.get(position).getIdLeague());
                mBundle.putString("nama",items.get(position).getStrTeam());
                mBundle.putString("logo",items.get(position).getStrTeamBadge());
                mBundle.putString("namapendek", (String) items.get(position).getStrTeamShort());
                mBundle.putString("namaalternatif",items.get(position).getStrAlternate());
                mBundle.putString("tahun",items.get(position).getIntFormedYear());
                mBundle.putString("namastadion",items.get(position).getStrStadium());
                mBundle.putString("lokasitadion",items.get(position).getStrStadiumLocation());
                mBundle.putString("kapasitasstadion",items.get(position).getIntStadiumCapacity());
                mBundle.putString("negara",items.get(position).getStrCountry());
                intent.putExtras(mBundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivLogo;
        TextView tvNama;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivLogo=itemView.findViewById(R.id.ivLogo);
            tvNama=itemView.findViewById(R.id.tvNama);

            this.itemView=itemView;
        }
    }

}
