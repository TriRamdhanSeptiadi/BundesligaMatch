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
import com.example.bundesligamatch.model.ResponseTeam;
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

public class TeamFragment extends Fragment {

    private ProgressBar mainProgressBar;
    private RecyclerView rvTeam;
    private Context context;
    private AdapterAllTeam adapter;
    private List<TeamsItem> items = new ArrayList<>();
    private ApiInterface apiInterface;

    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_team, container, false);
        rvTeam = rootView.findViewById(R.id.rvTeam);
        context = getActivity();

        adapter = new AdapterAllTeam(context, items);

        rvTeam.setLayoutManager(new GridLayoutManager(context, 2));
        rvTeam.setAdapter(adapter);

        apiInterface = RetrofitClient.getRetrofitClient().create(ApiInterface.class);

        getAllLeague();

        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainProgressBar = view.findViewById(R.id.mainProgressBar);
        rvTeam = view.findViewById(R.id.rvTeam);
    }

    private void getAllLeague() {
        Call<ResponseTeam> api = apiInterface.getAllTeam();

        api.enqueue(new Callback<ResponseTeam>() {
            @Override
            public void onResponse(Call<ResponseTeam> call, Response<ResponseTeam> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setItems(response.body().getTeams());
                    adapter.notifyDataSetChanged();
                }mainProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResponseTeam> call, Throwable t) {
                // Handle failure
            }
        });
    }
}