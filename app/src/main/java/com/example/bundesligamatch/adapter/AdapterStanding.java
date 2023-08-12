package com.example.bundesligamatch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundesligamatch.R;
import com.example.bundesligamatch.model.TableItem;
import com.example.bundesligamatch.model.TeamsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

public class AdapterStanding extends RecyclerView.Adapter<AdapterStanding.ViewHolder> {

    Context context;
    List<TableItem> items;

    public AdapterStanding(Context context, List<TableItem> items) {
        this.context = context;
        this.items = items;
    }

    public void setItems(List<TableItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public AdapterStanding.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.standing_item,parent,false);
        return new AdapterStanding.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterStanding.ViewHolder holder, int position) {
        holder.tvPosition.setText(items.get(position).getIntRank());
        holder.tvTeamName.setText(items.get(position).getStrTeam());
        holder.tvPlayed.setText(items.get(position).getIntPlayed());
        holder.tvWin.setText(items.get(position).getIntWin());
        holder.tvDraw.setText(items.get(position).getIntDraw());
        holder.tvLose.setText(items.get(position).getIntLoss());
        holder.tvGFGA.setText(items.get(position).getIntGoalsFor() + "-" +items.get(position).getIntGoalsAgainst());
        holder.tvGD.setText(items.get(position).getIntGoalDifference());
        holder.tvPts.setText(items.get(position).getIntPoints());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvPosition;
        TextView tvTeamName;
        TextView tvPlayed;
        TextView tvWin;
        TextView tvDraw;
        TextView tvLose;
        TextView tvGFGA;
        TextView tvGD;
        TextView tvPts;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPosition=itemView.findViewById(R.id.tvPosition);
            tvTeamName=itemView.findViewById(R.id.tvTeamName);
            tvPlayed=itemView.findViewById(R.id.tvPlayed);
            tvWin=itemView.findViewById(R.id.tvWin);
            tvDraw=itemView.findViewById(R.id.tvDraw);
            tvLose=itemView.findViewById(R.id.tvLose);
            tvGFGA=itemView.findViewById(R.id.tvGFGA);
            tvGD=itemView.findViewById(R.id.tvGD);
            tvPts=itemView.findViewById(R.id.tvPts);

            this.itemView=itemView;
        }
    }

}
