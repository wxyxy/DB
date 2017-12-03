package com.bwei.moniweekone.utils;

import com.bwei.moniweekone.bean.Bean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hp on 2017/12/2.
 */
public interface IGetDataBase {
    //get请求
    @GET("nba/?")
    Call<Bean> get(@Query("key") String key, @Query("num") int num);
    //post请求
    @FormUrlEncoded
    @POST("nba/?")
    Call<Bean> post(@Field("key") String key, @Field("num") int num);
}
