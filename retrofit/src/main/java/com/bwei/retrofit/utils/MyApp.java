package com.bwei.retrofit.utils;

import android.app.Application;

import com.afa.tourism.greendao.gen.DaoMaster;
import com.afa.tourism.greendao.gen.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.greenrobot.greendao.database.Database;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 2017/12/1.
 */
public class MyApp extends Application {

    public static IGetDataBase iGetDataBase;
    public static DaoSession session;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化fresco
        Fresco.initialize(this);
        //初始化retrofit
        Retrofit retrofit =  new Retrofit.Builder().baseUrl("http://api.tianapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iGetDataBase = retrofit.create(IGetDataBase.class);
        //初始化greendao
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"biao");
        Database database =  helper.getWritableDb();
        session = new DaoMaster(database).newSession();
    }
}
