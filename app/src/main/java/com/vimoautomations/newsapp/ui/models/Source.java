package com.vimoautomations.newsapp.ui.models;

import com.google.gson.annotations.SerializedName;

public class Source{
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;

    public Source(String name) {
        this.name = name;
    }
}