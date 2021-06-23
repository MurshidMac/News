package com.vimoautomations.newsapp.ui.viewmodels;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vimoautomations.newsapp.ui.models.News;
import com.vimoautomations.newsapp.ui.repositories.NewsRepository;
import com.vimoautomations.newsapp.ui.util.Resource;

import java.io.IOException;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {

    private static final String TAG = "NewsViewModel";
    NewsRepository repository;
    Disposable compositeDisposable = new CompositeDisposable();
    public MutableLiveData<Resource<News>> breakingNewsLivedata;
    public Integer breakingNewsPage = 2;
    public Call<News> newsResponse;

    public NewsViewModel(NewsRepository repository){
        this.repository = repository;
        // Initial ViewModel Call
        newsResponse = load("us",1);
        if(newsResponse == null){
            newsResponse = load("us", 1);
            Log.d(TAG, "NewsViewModel News Response is null");
            getBreakingNews("us");
        }
    }

    public Call<News> load(String countryCode, Integer pagenumber){
        if(breakingNewsLivedata == null){
            breakingNewsLivedata = new MutableLiveData<>();
            breakingNewsLivedata = getBreakingNews("us");
        }
        return this.repository.getBreakingNews(countryCode, breakingNewsPage);
    }

    public MutableLiveData<Resource<News>> getBreakingNews(String countryCode) {
        newsResponse = this.repository.getBreakingNews(countryCode, breakingNewsPage);
        breakingNewsLivedata.postValue(new Resource.Load<News>(new News()));
        breakingNewsLivedata.postValue(handleBreakingNewsResponse(newsResponse));
        return breakingNewsLivedata;
    }

    private Resource<News> handleBreakingNewsResponse(Call<News> response){
        if(response != null){
            try{
            Response<News> value = response.execute();
            if(value != null && value.body() != null) {
                 Resource<News> news;
                 news = new Resource.Success<News>(value.body());
                 return news;
            }
            }catch (IOException e){
                Log.e(TAG, "IOEXCEPTION");
            }finally {
                return new Resource.Error<News>("ERROR", new Exception());
            }
        }
        return new Resource.Error<News>("ERROR", new Exception());
    }


    private void getSuperHeroes(String search, Integer pageNumber) {
        //RetrofitClient.getInstance().getMyApi().getBreakingEveryThing()



//        retrofit2.Call<News> call = RetrofitClient.getInstance().getMyApi().getNewsEveryThing("" +
//                search, AppConfig.publishSortOrder, AppConfig.apiKey);
//        call.enqueue(new Callback<News>() {
//            @Override
//            public void onResponse(Call<News> call, Response<News> response) {
//                News myheroList = response.body();
//                String[] oneHeroes = new String[myheroList.getArticles().size()];
//                List<Article> list= myheroList.getArticles();
//                for (int i = 0; i < list.size(); i++) {
//                    oneHeroes[i] = myheroList.getArticles().get(i).author;
//                    Log.d(TAG, "AutherName:  "+ myheroList.getArticles().get(i).author);
//                }
//                //superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
//            }
//
//            @Override
//            public void onFailure(Call<News> call, Throwable t) {
//                Log.e("Error", "Network call");
//            }
//
//        });
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
