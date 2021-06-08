package com.vimoautomations.newsapp.ui.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.vimoautomations.newsapp.ui.contants.AppConfig;
import com.vimoautomations.newsapp.ui.models.Article;
import com.vimoautomations.newsapp.ui.models.dao.ArticleDao;
import com.vimoautomations.newsapp.ui.db.typeconverters.RoomConverters;

import org.jetbrains.annotations.NotNull;

@Database(
       entities = Article.class, version = 1
)
@TypeConverters(
        RoomConverters.class
)
public abstract class NewsArticlesDB extends RoomDatabase {

    abstract ArticleDao getArticleDao();

    private static final String DB_NAME = AppConfig.DATABASE_NAME;
    private static volatile NewsArticlesDB instance;

    static synchronized NewsArticlesDB getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }
     NewsArticlesDB() {};

    @NotNull
    private static NewsArticlesDB create(final Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                NewsArticlesDB.class,
                DB_NAME).build();
    }

}