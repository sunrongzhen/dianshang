package com.example.administrator.jingdong.presenter;

import com.example.administrator.jingdong.model.FenlleishangpinModel;
import com.example.administrator.jingdong.view.IFenleishangpinView;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class Pfenleishangpin implements IPfenleishangpin {
    private IFenleishangpinView iFenleishangpinView;

    private FenlleishangpinModel fenlleishangpinModel;

    public Pfenleishangpin(IFenleishangpinView iFenleishangpinView) {
        this.iFenleishangpinView = iFenleishangpinView;
        fenlleishangpinModel=new FenlleishangpinModel();
    }

    @Override
    public void Yes(Object o) {
        if (iFenleishangpinView==null){
            return;
        }
        iFenleishangpinView.Yes(o);
    }

    @Override
    public void No(String e) {
        if (iFenleishangpinView==null){
            return;
        }
        iFenleishangpinView.No(e);
    }

    @Override
    public void getData(int pscid) {
        fenlleishangpinModel.getData(pscid,this);

    }

    @Override
    public void onDestory() {
        if (iFenleishangpinView!=null){
            iFenleishangpinView=null;
        }
    }
}
