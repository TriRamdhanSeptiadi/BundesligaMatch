package com.example.bundesligamatch.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

public class RetrofitClient {
    public static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/3/";
    public static Retrofit retrofit=null;

    public static Retrofit getRetrofitClient(){
        if(retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
