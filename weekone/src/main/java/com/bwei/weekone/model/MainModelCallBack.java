package com.bwei.weekone.model;

import com.bwei.weekone.bean.Bean;

/**
 * Created by hp on 2017/12/1.
 */
public interface MainModelCallBack {
    public void Success(Bean bean);

    public void Failure(Exception e);
}
