package com.bwei.retrofit.model;

import com.bwei.retrofit.Bean;
import com.bwei.retrofit.utils.MyApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp on 2017/12/1.
 */
public class MainModel {
    public void getData(final MainModelCallBack callBack) {
        Call<Bean> call = MyApp.iGetDataBase.get("11ebce8ebe253e019b886ae1547b07d7", 20);
        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean bean = response.body();
                callBack.Success(bean);
                //存储到数据库
                MyApp.session.getNewslistBeanDao().insertInTx(bean.getNewslist());
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                callBack.Failure(new Exception());
            }
        });
    }
}
