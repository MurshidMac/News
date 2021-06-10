package com.vimoautomations.newsapp.ui.repositories;

import android.content.Context;

import com.vimoautomations.newsapp.ui.api.RetrofitClient;
import com.vimoautomations.newsapp.ui.contants.AppConfig;
import com.vimoautomations.newsapp.ui.db.NewsArticlesDB;
import com.vimoautomations.newsapp.ui.models.News;

import java.io.IOException;

public class NewsRepository {
    NewsArticlesDB db;
    Context context;
    public NewsRepository(Context context){
        this.context = context;
        this.db = db.getInstance(context);
    }
    public void getBreakingNews(String countryCode, Integer pageNumber) {
         RetrofitClient.getInstance().getMyApi().getBreakingEveryThing(countryCode,
                pageNumber, AppConfig.apiKey);

    }
}
