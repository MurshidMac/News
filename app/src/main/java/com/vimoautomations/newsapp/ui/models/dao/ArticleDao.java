package com.vimoautomations.newsapp.ui.models.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vimoautomations.newsapp.ui.models.Article;

import java.util.List;


@Dao
public interface ArticleDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Article object);

    @Delete
    void delete(Article object);

    @Query("SELECT * FROM articles")
    LiveData<List<Article>> getAllArticles();
}