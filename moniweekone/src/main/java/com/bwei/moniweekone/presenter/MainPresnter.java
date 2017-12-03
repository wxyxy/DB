package com.bwei.moniweekone.presenter;

import com.bwei.moniweekone.bean.Bean;
import com.bwei.moniweekone.bean.NewslistBean;
import com.bwei.moniweekone.model.MainModel;
import com.bwei.moniweekone.model.MainModelCallBack;
import com.bwei.moniweekone.utils.MyApp;
import com.bwei.moniweekone.view.MainView;

import java.util.List;

/**
 * Created by hp on 2017/12/2.
 */
public class MainPresnter {

    private MainView mainView;
    private MainModel mainModel;

    public MainPresnter(MainView mainView) {
        this.mainView = mainView;
        this.mainModel = new MainModel();
    }

    public List<NewslistBean> getdb(){
        List<NewslistBean> list = mainModel.getdb(MyApp.session);
        return list;
    }

    public void get() {
        mainModel.getData(new MainModelCallBack() {
            @Override
            public void Success(Bean bean) {
                if (mainView != null) {
                    mainView.Success(bean);
                }
            }

            @Override
            public void Failure(Exception e) {
                if (mainView != null) {
                    mainView.Failure(e);
                }
            }
        });
    }

    public void post() {
        mainModel.getData(new MainModelCallBack() {
            @Override
            public void Success(Bean bean) {
                if (mainView != null) {
                    mainView.Success(bean);
                }
            }

            @Override
            public void Failure(Exception e) {
                if (mainView != null) {
                    mainView.Failure(e);
                }
            }
        });
    }
}
