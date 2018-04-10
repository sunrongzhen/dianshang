package com.example.administrator.jingdong.presenter;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public interface IPresenter2Classify {
    void onFailed(String msg);

    void onSuccess(Object o);
    void getData(int page);

}
