package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.model.SpxiangpingModel;
import com.example.administrator.jingdong.view.ISpxiangpingView;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class SpxiangpingP implements ISpxiangpingP {
    private ISpxiangpingView iSpxiangpingView;

    private SpxiangpingModel spxiangpingModel;
    public SpxiangpingP(ISpxiangpingView iSpxiangpingView) {
        this.iSpxiangpingView = iSpxiangpingView;
        spxiangpingModel=new SpxiangpingModel();
    }

    @Override
    public void Yes(Object o) {
        if (iSpxiangpingView==null){
            return;
        }
        iSpxiangpingView.Yes(o);

    }

    @Override
    public void No(String e) {
        if (iSpxiangpingView==null){
            return;
        }
        iSpxiangpingView.No(e);
    }

    @Override
    public void getData(int pid) {
        spxiangpingModel.getData(pid,this);

    }

    @Override
    public void onDestory() {
        if (iSpxiangpingView!=null){
            iSpxiangpingView=null;
        }

    }
}
