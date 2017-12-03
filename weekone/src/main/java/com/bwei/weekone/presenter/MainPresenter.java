package com.bwei.weekone.presenter;

import com.bwei.weekone.bean.Bean;
import com.bwei.weekone.model.MainModel;
import com.bwei.weekone.model.MainModelCallBack;
import com.bwei.weekone.view.MainView;

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
                if (mainView != null){
                    mainView.Success(bean);
                }
            }

            @Override
            public void Failure(Exception e) {
                if(mainView != null){
                    mainView.Failure(e);
                }
            }
        });
    }
}
