package com.vimoautomations.newsapp.ui.viewmodels;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vimoautomations.newsapp.ui.api.NewsApi;
import com.vimoautomations.newsapp.ui.api.RetrofitClient;
import com.vimoautomations.newsapp.ui.contants.AppConfig;
import com.vimoautomations.newsapp.ui.models.Article;
import com.vimoautomations.newsapp.ui.models.News;
import com.vimoautomations.newsapp.ui.repositories.NewsRepository;
import com.vimoautomations.newsapp.ui.util.Resource;

import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    NewsRepository repository;
    private static final String TAG = "NewsViewModel";
    News elment;
    public NewsViewModel(NewsRepository repository){
        this.repository = repository;
    }
    Disposable compositeDisposable = new CompositeDisposable();
    public MutableLiveData<Resource<News>> liveData = new MutableLiveData<>();
    public Integer breakingNewsPage = 1;

    public void load(String countryCode, Integer pagenumber){
        getSuperHeroes("bitcoin",11);
        repository.getBreakingNews(countryCode, pagenumber);
    }

    private void getSuperHeroes(String search, Integer pageNumber) {
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
                Log.e("Error", "Network call");
            }

        });
    }


    private void SetNewsItem(News news){
        this.elment = news;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
