package com.vimoautomations.newsapp.ui.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vimoautomations.newsapp.R;
import com.vimoautomations.newsapp.ui.NewsActivity;
import com.vimoautomations.newsapp.ui.viewmodels.NewsViewModel;

import org.jetbrains.annotations.NotNull;

public class ArticleFragments extends Fragment {

    NewsViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull @NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NewsActivity parentActivity = (NewsActivity) getActivity();
        viewModel = parentActivity.viewModel;

    }

    public ArticleFragments(){
        super(R.layout.fragment_articles);
    }
}
