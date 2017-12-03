package com.bwei.retrofit.presenter;

import com.bwei.retrofit.Bean;
import com.bwei.retrofit.model.MainModel;
import com.bwei.retrofit.model.MainModelCallBack;
import com.bwei.retrofit.view.MainView;

/**
 * Created by hp on 2017/12/1.
 */
public class MainPresenter {

    private MainView mainView;
    private MainModel mainModel;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        this.mainModel = new MainModel();
    }

    public void get(){
        mainModel.getData(new MainModelCallBack() {
            @Override
            public void Success(Bean bean) {
                if(mainView != null){
                    mainView.Success(bean);
                }
            }

            @Override
            public void Failure(Exception e) {
                if (mainView != null){
                    mainView.Failure(e);
                }
            }
        });
    }

    public void post(){
        mainModel.getData(new MainModelCallBack() {
            @Override
            public void Success(Bean bean) {
                if(mainView != null){
                    mainView.Success(bean);
                }
            }

            @Override
            public void Failure(Exception e) {
                if (mainView != null){
                    mainView.Failure(e);
                }
            }
        });
    }

}
