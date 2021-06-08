package com.vimoautomations.newsapp.ui.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
@Entity(
        tableName = "articles"
)
public class Article{

    @PrimaryKey(autoGenerate = true)
    public int id;

    public Article(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    @SerializedName("source")
    public Source source;
    @SerializedName("author")
    public String author;
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("url")
    public String url;

    public String getAuthor() {
        return author;
    }

    @SerializedName("urlToImage")
    public String urlToImage;
    @SerializedName("publishedAt")
    public Date publishedAt;
    @SerializedName("content")
    public String content;
}