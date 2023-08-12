package com.example.bundesligamatch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundesligamatch.R;
import com.example.bundesligamatch.model.EventsItem;
import com.example.bundesligamatch.model.TableItem;

import java.util.List;

// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

public class AdapterMatch extends RecyclerView.Adapter<AdapterMatch.ViewHolder> {

    Context context;
    List<EventsItem> items;

    public AdapterMatch(Context context, List<EventsItem> items) {
        this.context = context;
        this.items = items;
    }

    public void setItems(List<EventsItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public AdapterMatch.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_item,parent,false);
        return new AdapterMatch.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMatch.ViewHolder holder, int position) {
        holder.homeNameTv.setText(items.get(position).getStrHomeTeam());
        holder.homeScoreTv.setText(items.get(position).getIntHomeScore());
        holder.awayScoreTv.setText(items.get(position).getIntAwayScore());
        holder.awayNameTv.setText(items.get(position).getStrAwayTeam());
        holder.dateScheduleTv.setText(items.get(position).getDateEvent());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView homeNameTv;
        TextView homeScoreTv;
        TextView awayScoreTv;
        TextView awayNameTv;
        TextView dateScheduleTv;

        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            homeNameTv=itemView.findViewById(R.id.homeNameTv);
            homeScoreTv=itemView.findViewById(R.id.homeScoreTv);
            awayScoreTv=itemView.findViewById(R.id.awayScoreTv);
            awayNameTv=itemView.findViewById(R.id.awayNameTv);
            dateScheduleTv=itemView.findViewById(R.id.dateScheduleTv);

            this.itemView=itemView;
        }
    }

}
