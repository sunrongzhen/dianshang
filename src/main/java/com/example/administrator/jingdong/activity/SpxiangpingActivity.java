package com.example.administrator.jingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.adapter.MySpxiangpingAdapter;
import com.example.administrator.jingdong.bean.SpxiangpingBean;
import com.example.administrator.jingdong.presenter.SpxiangpingP;
import com.example.administrator.jingdong.view.ISpxiangpingView;

import java.util.ArrayList;
import java.util.List;

public class SpxiangpingActivity extends BaseActivity implements ISpxiangpingView {

    private RecyclerView mSpxiangpingrv;
    private SpxiangpingP spxiangpingP;
    private List<SpxiangpingBean.DataBean> list;


    @Override
    protected int getLayout() {
        return R.layout.activity_spxiangping;
    }

    protected void initView() {
        mSpxiangpingrv = (RecyclerView) findViewById(R.id.spxiangpingrv);
    }

    @Override
    protected void initData() {
        Intent intent = new Intent();
        int pid = intent.getIntExtra("pid", 0);


        spxiangpingP = new SpxiangpingP(this);
        spxiangpingP.getData(pid);

    }

    @Override
    public void Yes(Object o) {
        SpxiangpingBean o1 = (SpxiangpingBean) o;
        SpxiangpingBean.DataBean data = o1.getData();
        list=new ArrayList<>();
        list.add(data);


        MySpxiangpingAdapter mySpxiangpingAdapter = new MySpxiangpingAdapter(SpxiangpingActivity.this, list);

        mSpxiangpingrv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mSpxiangpingrv.setAdapter(mySpxiangpingAdapter);


    }

    @Override
    public void No(String e) {

    }
}
