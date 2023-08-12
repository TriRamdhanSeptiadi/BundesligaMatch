package com.example.bundesligamatch.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.bundesligamatch.R;
import com.example.bundesligamatch.adapter.AdapterAllTeam;
import com.example.bundesligamatch.adapter.AdapterStanding;
import com.example.bundesligamatch.model.ResponseStanding;
import com.example.bundesligamatch.model.ResponseTeam;
import com.example.bundesligamatch.model.TableItem;
import com.example.bundesligamatch.model.TeamsItem;
import com.example.bundesligamatch.network.ApiInterface;
import com.example.bundesligamatch.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

public class StandingFragment extends Fragment {

    private ProgressBar mainProgressBar;
    private RecyclerView rvStanding;
    private Context context;
    private AdapterStanding adapter;
    private List<TableItem> items = new ArrayList<>();
    private ApiInterface apiInterface;

    public StandingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_standing, container, false);
        rvStanding = rootView.findViewById(R.id.rvStanding);
        context = getActivity();

        adapter = new AdapterStanding(context, items);

        rvStanding.setLayoutManager(new GridLayoutManager(context, 1));
        rvStanding.setAdapter(adapter);

        apiInterface = RetrofitClient.getRetrofitClient().create(ApiInterface.class);

        getAllTeamStanding();

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainProgressBar = view.findViewById(R.id.mainProgressBar);
        rvStanding = view.findViewById(R.id.rvStanding);
    }

    private void getAllTeamStanding() {
        Call<ResponseStanding> api = apiInterface.getAllStanding();

        api.enqueue(new Callback<ResponseStanding>() {
            @Override
            public void onResponse(Call<ResponseStanding> call, Response<ResponseStanding> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setItems(response.body().getTable());
                    adapter.notifyDataSetChanged();
                }mainProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResponseStanding> call, Throwable t) {
                // Handle failure
            }
        });
    }
}