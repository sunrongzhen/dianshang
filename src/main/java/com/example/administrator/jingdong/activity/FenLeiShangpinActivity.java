package com.example.administrator.jingdong.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.adapter.MyClassifyAdapter;
import com.example.administrator.jingdong.adapter.MyFenleishangpinAdapter;
import com.example.administrator.jingdong.bean.FenleishangpinBean;
import com.example.administrator.jingdong.presenter.Pfenleishangpin;
import com.example.administrator.jingdong.view.IFenleishangpinView;

import java.util.List;

public class FenLeiShangpinActivity extends BaseActivity implements IFenleishangpinView {


    private RecyclerView mFenleishangpinrv;
    private Pfenleishangpin pfenleishangpin;

    @Override
    protected int getLayout() {
        return R.layout.activity_fen_lei_shangpin;
    }

    @Override
    protected void initView() {

        mFenleishangpinrv = (RecyclerView) findViewById(R.id.fenleishangpinrv);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();

        int pscid = intent.getIntExtra("pscid", 0);
        pfenleishangpin = new Pfenleishangpin(this);
        pfenleishangpin.getData(pscid);
    }


    @Override
    public void Yes(Object o) {
        FenleishangpinBean o1 = (FenleishangpinBean) o;
        final List<FenleishangpinBean.DataBean> data = o1.getData();
        MyFenleishangpinAdapter myFenleishangpinAdapter = new MyFenleishangpinAdapter(this, data);


        mFenleishangpinrv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mFenleishangpinrv.setAdapter(myFenleishangpinAdapter);
        myFenleishangpinAdapter.setOnItemClickListener(new MyClassifyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                int pid = data.get(position).getPid();

            }
        });
    }

    @Override
    public void No(String e) {

    }


}
