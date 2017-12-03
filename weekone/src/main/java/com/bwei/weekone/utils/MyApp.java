package com.bwei.weekone.utils;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 2017/12/1.
 */
public class MyApp extends Application {

    public static IGetDataBase iGetDataBase;

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.tianapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iGetDataBase = retrofit.create(IGetDataBase.class);
    }
}
