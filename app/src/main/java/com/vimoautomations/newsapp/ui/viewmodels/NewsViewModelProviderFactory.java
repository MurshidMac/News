package com.vimoautomations.newsapp.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.vimoautomations.newsapp.ui.repositories.NewsRepository;

import org.jetbrains.annotations.NotNull;


public class NewsViewModelProviderFactory implements ViewModelProvider.Factory {

    NewsRepository repository;
    public NewsViewModelProviderFactory(NewsRepository repository){
        this.repository = repository;
    }

    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        //if(modelClass.isAssignableFrom(NewsViewModel.class)){
            return (T) new NewsViewModel(this.repository);
        //}
        //throw new IllegalArgumentException("Unknown ViewModel Class");
    }
}
