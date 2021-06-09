package com.vimoautomations.newsapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vimoautomations.newsapp.R;
import com.vimoautomations.newsapp.ui.contants.AppConfig;
import com.vimoautomations.newsapp.ui.api.RetrofitClient;
import com.vimoautomations.newsapp.ui.models.Article;
import com.vimoautomations.newsapp.ui.models.News;

import java.util.List;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Log.i("Item selected ID"," clicked item"+ bottomNavigationView.getSelectedItemId());
        getSuperHeroes("elon musk");
    }

    private void getSuperHeroes(String search) {
        retrofit2.Call<News> call = RetrofitClient.getInstance().getMyApi().getNewsEveryThing("" +
                search, AppConfig.publishSortOrder, AppConfig.apiKey);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News myheroList = response.body();
                String[] oneHeroes = new String[myheroList.getArticles().size()];
                List<Article> list= myheroList.getArticles();
                for (int i = 0; i < list.size(); i++) {
                    oneHeroes[i] = myheroList.getArticles().get(i).author;
                    Log.d(TAG, "AutherName:  "+ myheroList.getArticles().get(i).author);
                }
                //superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}