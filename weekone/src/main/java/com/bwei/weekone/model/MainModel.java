package com.bwei.weekone.model;

import com.bwei.weekone.bean.Bean;
import com.bwei.weekone.utils.MyApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp on 2017/12/1.
 */
public class MainModel {
    public void getData(final MainModelCallBack callBack) {
        Call<Bean> call = MyApp.iGetDataBase.get("11ebce8ebe253e019b886ae1547b07d7", 50);
        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean bean = response.body();
                callBack.Success(bean);
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                callBack.Failure(new Exception());
            }
        });
    }
}
