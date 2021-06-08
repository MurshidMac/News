package com.vimoautomations.newsapp.ui.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    @SerializedName("status")
    public String status;
    @SerializedName("totalResults")
    public int totalResults;

    public List<Article> getArticles() {
        return articles;
    }

    @SerializedName("articles")
    public List<Article> articles;
}
