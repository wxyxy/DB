package com.bwei.weekone.utils;

import com.bwei.weekone.bean.Bean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hp on 2017/12/1.
 */
public interface IGetDataBase {

    @GET("/nba/?")
    Call<Bean> get(@Query("key") String key, @Query("num") int num);

    @FormUrlEncoded
    @POST("/nba/?")
    Call<Bean> post(@Field("key") String key);
}
