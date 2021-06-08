package com.vimoautomations.newsapp.ui.api.intercepters;

import android.util.Log;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class LoggingInterceptor implements Interceptor {
    Request request;
    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        request = chain.request();
        long t1 = System.nanoTime();
        Response response = chain.proceed(this.request);
        long t2 = System.nanoTime();
        return response;
    }
}
