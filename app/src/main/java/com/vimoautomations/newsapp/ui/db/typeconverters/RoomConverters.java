package com.vimoautomations.newsapp.ui.db.typeconverters;

import androidx.room.TypeConverter;

import com.vimoautomations.newsapp.ui.models.Article;
import com.vimoautomations.newsapp.ui.models.Source;

import java.util.Date;

public class RoomConverters {
    @TypeConverter
    public String fromSource(Source source){
        return source.id + " " +source.name;
    }

    @TypeConverter
    public Source toSource(String source){
        return new Source(source);
    }

    @TypeConverter
    public static Date toDate(Long dateLong){
        return dateLong == null ? null: new Date(dateLong);
    }

    @TypeConverter
    public static Long fromDate(Date date){
        return date == null ? null : date.getTime();
    }

}
