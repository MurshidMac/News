package com.vimoautomations.newsapp.ui.models.dao.base;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vimoautomations.newsapp.ui.models.Article;

import java.util.List;

public interface BaseDao<T> {

    boolean insert(T object);

    boolean delete(T object);

}
