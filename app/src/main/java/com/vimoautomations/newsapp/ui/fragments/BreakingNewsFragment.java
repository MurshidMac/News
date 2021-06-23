package com.vimoautomations.newsapp.ui.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vimoautomations.newsapp.R;
import com.vimoautomations.newsapp.ui.NewsActivity;
import com.vimoautomations.newsapp.ui.adapters.NewsAdapter;
import com.vimoautomations.newsapp.ui.util.Resource;
import com.vimoautomations.newsapp.ui.viewmodels.NewsViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BreakingNewsFragment extends Fragment {

    NewsViewModel viewModel;
    NewsAdapter adapter;

    RecyclerView recyclerView;
    ProgressBar progressbar;
    public BreakingNewsFragment(){
        super(R.layout.fragment_breaking);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NewsActivity parentActivity =  (NewsActivity) getParentFragment().getActivity();
        recyclerView = view.findViewById(R.id.rvBreakingNews);
        viewModel = parentActivity.viewModel;
        setRecyclerView();
        progressbar = view.findViewById(R.id.paginationProgressBar_breaking);
        //loadMutableData();
    }

    private void hideProgressBar() {
        progressbar.setVisibility(View.INVISIBLE);
    }

    private void showProgressBar() {
        progressbar.setVisibility(View.VISIBLE);
    }
    private void loadMutableData(){
        viewModel.breakingNewsLivedata
                .observe(getViewLifecycleOwner(),
                        (newsResource) -> {
                            // if result is not equal to null
                            if( newsResource.data != null){
                                hideProgressBar();
                                if(newsResource.data.getArticles() != null){
                                    adapter.differ.submitList(newsResource.data.articles);
                                }
                            }
                            // if result is equal to load
                            if(newsResource.message == "LOAD"){
                                showProgressBar();
                            }

                            if(newsResource.message == "ERROR"){
                                hideProgressBar();
                                Log.e("BREAKING_NEWS_FRAGMENT","ERROR resource");
                            }
                        });
    }

    private void setRecyclerView(){
        adapter = new NewsAdapter(getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
