package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.model.Classify2Model;
import com.example.administrator.jingdong.view.IClassify2View;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class Presenter2Classify implements IPresenter2Classify {
    private IClassify2View iClassify2View;
    private Classify2Model classify2Model;
    public Presenter2Classify(IClassify2View iClassify2View) {
        this.iClassify2View = iClassify2View;
        classify2Model=new Classify2Model();
    }

    @Override
    public void onFailed(String msg) {
        if (iClassify2View==null){
            return;
        }
        iClassify2View.onFailed(msg);

    }

    @Override
    public void onSuccess(Object o) {
        if (iClassify2View==null){
            return;
        }
        iClassify2View.onSuccess(o);
    }

    @Override
    public void getData(int page) {
        classify2Model.getData(page,this);

    }


}
