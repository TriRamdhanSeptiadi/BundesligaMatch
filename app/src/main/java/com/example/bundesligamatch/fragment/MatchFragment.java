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
import com.example.bundesligamatch.adapter.AdapterMatch;
import com.example.bundesligamatch.adapter.AdapterStanding;
import com.example.bundesligamatch.model.EventsItem;
import com.example.bundesligamatch.model.ResponseMatch;
import com.example.bundesligamatch.model.ResponseStanding;
import com.example.bundesligamatch.model.TableItem;
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

public class MatchFragment extends Fragment {

    private ProgressBar mainProgressBar;
    private RecyclerView rvMatch;
    private Context context;
    private AdapterMatch adapter;
    private List<EventsItem> items = new ArrayList<>();
    private ApiInterface apiInterface;

    public MatchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_match, container, false);
        rvMatch = rootView.findViewById(R.id.rvMatch);
        context = getActivity();

        adapter = new AdapterMatch(context, items);

        rvMatch.setLayoutManager(new GridLayoutManager(context, 1));
        rvMatch.setAdapter(adapter);

        apiInterface = RetrofitClient.getRetrofitClient().create(ApiInterface.class);

        getAllMatch();

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainProgressBar = view.findViewById(R.id.mainProgressBar);
        rvMatch = view.findViewById(R.id.rvMatch);
    }

    private void getAllMatch() {
        Call<ResponseMatch> api = apiInterface.getAllMatch();

        api.enqueue(new Callback<ResponseMatch>() {
            @Override
            public void onResponse(Call<ResponseMatch> call, Response<ResponseMatch> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setItems(response.body().getEvents());
                    adapter.notifyDataSetChanged();
                }mainProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResponseMatch> call, Throwable t) {
                // Handle failure
            }
        });
    }
}