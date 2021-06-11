package com.vimoautomations.newsapp.ui.api;

import androidx.annotation.Nullable;

import com.vimoautomations.newsapp.ui.models.News;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("v2/everything")
    Call<News> getNewsEveryThing(@Query("q")String search,
                                 @Nullable @Query("sortBy") String SortBy,
                                 @Query("apiKey") String apiKey);
    @GET("v2/top-headlines")
    Call<News> getBreakingEveryThing(@Query("country")String countryCode,
                                       @Nullable @Query("page") Integer pageNumber,
                                       @Query("apiKey") String apiKey);

}
