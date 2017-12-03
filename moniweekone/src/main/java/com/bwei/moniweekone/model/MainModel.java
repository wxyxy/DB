package com.bwei.moniweekone.model;

import com.afa.tourism.greendao.gen.DaoSession;
import com.bwei.moniweekone.bean.Bean;
import com.bwei.moniweekone.bean.NewslistBean;
import com.bwei.moniweekone.utils.MyApp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp on 2017/12/2.
 */
public class MainModel {

    public void getData(final MainModelCallBack callBack) {
        //拼接字符串进行网络获取
        Call<Bean> call = MyApp.iGetDataBase.get("11ebce8ebe253e019b886ae1547b07d7", 50);
        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean bean = response.body();
                callBack.Success(bean);
                //把数据添加到数据库
                MyApp.session.getNewslistBeanDao().insertInTx(bean.getNewslist());
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                callBack.Failure(new Exception());
            }
        });
    }

    //定义一个传输获取到数据库内所有的值
    public List<NewslistBean> getdb(DaoSession session) {
        List<NewslistBean> list = session.getNewslistBeanDao().loadAll();
        return list;
    }
}
