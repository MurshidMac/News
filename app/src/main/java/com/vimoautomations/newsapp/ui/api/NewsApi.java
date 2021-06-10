package com.vimoautomations.newsapp.ui.api;

import androidx.lifecycle.LiveData;

import com.vimoautomations.newsapp.ui.models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("v2/everything")
    Call<News> getNewsEveryThing(@Query("q")String search,
                                 @Query("sortBy") String SortBy,
                                 @Query("apiKey") String apiKey);

}
