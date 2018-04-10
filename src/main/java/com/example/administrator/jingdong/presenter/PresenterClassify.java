package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.model.ClassifyModel;
import com.example.administrator.jingdong.view.IClassifyView;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class PresenterClassify implements  IPresenterClassify{
    private IClassifyView iClassifyView;
    private ClassifyModel classifyModel;
    public PresenterClassify(IClassifyView iClassifyView) {
        this.iClassifyView = iClassifyView;
        classifyModel=new ClassifyModel();
    }

    @Override
    public void Yes(Object o) {
        if (iClassifyView==null){
            return;
        }
        iClassifyView.Yes(o);

    }

    @Override
    public void No(String e) {
        if (iClassifyView==null){
            return;
        }
        iClassifyView.No(e);

    }

    @Override
    public void getData() {
        classifyModel.getData(this);

    }

    @Override
    public void onDestory() {

        if (iClassifyView!=null){
            iClassifyView=null;
        }
    }
}
