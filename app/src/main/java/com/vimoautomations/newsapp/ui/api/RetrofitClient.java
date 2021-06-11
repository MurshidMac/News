package com.vimoautomations.newsapp.ui.api;

import com.vimoautomations.newsapp.ui.contants.AppConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private NewsApi myApi;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(AppConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        myApi = retrofit.create(NewsApi.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public NewsApi getMyApi() {
        return myApi;
    }
}
