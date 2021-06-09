package com.vimoautomations.newsapp.ui.util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.vimoautomations.newsapp.ui.models.Article;

public class DiffArticlesCallBack extends DiffUtil.ItemCallback<Article> {
    @Override
    public boolean areItemsTheSame(@NonNull Article oldItem, @NonNull  Article newItem) {
        return oldItem.url == newItem.url;
    }

    @Override
    public boolean areContentsTheSame(@NonNull  Article oldItem, @NonNull Article newItem) {
        return oldItem == newItem;
    }
}
