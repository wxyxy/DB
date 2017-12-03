package com.bwei.moniweekone.view;

import com.bwei.moniweekone.bean.Bean;

/**
 * Created by hp on 2017/12/2.
 */
public interface MainView {
    public void Success(Bean bean);

    public void Failure(Exception e);
}
