package com.vimoautomations.newsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vimoautomations.newsapp.R;
import com.vimoautomations.newsapp.ui.contants.AppConfig;
import com.vimoautomations.newsapp.ui.api.RetrofitClient;
import com.vimoautomations.newsapp.ui.db.NewsArticlesDB;
import com.vimoautomations.newsapp.ui.models.Article;
import com.vimoautomations.newsapp.ui.models.News;
import com.vimoautomations.newsapp.ui.repositories.NewsRepository;
import com.vimoautomations.newsapp.ui.viewmodels.NewsViewModel;
import com.vimoautomations.newsapp.ui.viewmodels.NewsViewModelProviderFactory;

import java.util.List;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    NewsRepository repo;
    NewsViewModelProviderFactory factory;
    public NewsViewModel viewModel;
    private NewsArticlesDB db;

    public NewsActivity(){
        super(R.layout.activity_news);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        repo = new NewsRepository(this, db);
        db = NewsArticlesDB.getInstance(this);
        viewModel = new NewsViewModel(repo);
        factory = new NewsViewModelProviderFactory(repo);
        viewModel = new ViewModelProvider(this, factory).get(NewsViewModel.class);
        Log.i("Item selected ID"," clicked item "+ bottomNavigationView.getSelectedItemId());
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.newsNavHostFragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());
    }


}