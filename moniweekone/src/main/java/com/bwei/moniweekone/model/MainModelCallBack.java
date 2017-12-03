package com.bwei.moniweekone.model;

import com.bwei.moniweekone.bean.Bean;

/**
 * Created by hp on 2017/12/2.
 */
public interface MainModelCallBack {
    public void Success(Bean bean);

    public void Failure(Exception e);
}
