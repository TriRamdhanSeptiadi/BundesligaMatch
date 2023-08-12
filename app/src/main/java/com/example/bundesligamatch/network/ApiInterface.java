package com.example.bundesligamatch.network;

import com.example.bundesligamatch.model.ResponseMatch;
import com.example.bundesligamatch.model.ResponseStanding;
import com.example.bundesligamatch.model.ResponseTeam;

import retrofit2.Call;
import retrofit2.http.GET;

// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

public interface ApiInterface {
    @GET("search_all_teams.php?l=German%20Bundesliga")
    Call<ResponseTeam> getAllTeam();

    @GET("lookuptable.php?l=4331&s=2022-2023")
    Call<ResponseStanding> getAllStanding();

    @GET("eventsseason.php?id=4331&s=2022-2023")
    Call<ResponseMatch> getAllMatch();

}
