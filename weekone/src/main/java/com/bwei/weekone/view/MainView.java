package com.bwei.weekone.view;

import com.bwei.weekone.bean.Bean;

/**
 * Created by hp on 2017/12/1.
 */
public interface MainView {
    public void Success(Bean bean);

    public void Failure(Exception e);
}
