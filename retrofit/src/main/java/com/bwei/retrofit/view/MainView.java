package com.bwei.retrofit.view;

import com.bwei.retrofit.Bean;

/**
 * Created by hp on 2017/12/1.
 */
public interface MainView {
    public void Success(Bean bean);
    public void Failure(Exception e);
}
