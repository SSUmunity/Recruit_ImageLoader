package com.example.forhack.imageloader.service;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by baehyeonbin on 2018. 2. 19..
 */

public interface MainService {
    String URL = "https://9py6g66w0m.execute-api.ap-northeast-2.amazonaws.com";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    @GET("/prod/android-recruit")
    public Call<String> getDataList();
}
