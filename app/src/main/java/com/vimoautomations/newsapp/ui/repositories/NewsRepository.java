package com.vimoautomations.newsapp.ui.repositories;

import android.content.Context;

import com.vimoautomations.newsapp.ui.api.RetrofitClient;
import com.vimoautomations.newsapp.ui.contants.AppConfig;
import com.vimoautomations.newsapp.ui.db.NewsArticlesDB;
import com.vimoautomations.newsapp.ui.models.News;

import retrofit2.Call;
import retrofit2.Response;

public class NewsRepository {
    NewsArticlesDB db;
    Context context;
    public NewsRepository(Context context, NewsArticlesDB db){
        this.context = context;
        this.db = db;
        this.db = db.getInstance(context);
    }
    // Getting a single news
    public Call<News> getBreakingNews(String countryCode, Integer pageNumber){
        return RetrofitClient.getInstance().getMyApi().getBreakingEveryThing(countryCode,
                pageNumber, AppConfig.apiKey);
    }

}
