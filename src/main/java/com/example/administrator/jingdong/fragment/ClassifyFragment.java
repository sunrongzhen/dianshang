package com.example.administrator.jingdong.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.adapter.MyClassify2Adapter;
import com.example.administrator.jingdong.adapter.MyClassifyAdapter;
import com.example.administrator.jingdong.bean.Classify2Bean;
import com.example.administrator.jingdong.bean.ClassifyBean;
import com.example.administrator.jingdong.presenter.Presenter2Classify;
import com.example.administrator.jingdong.presenter.PresenterClassify;
import com.example.administrator.jingdong.view.IClassify2View;
import com.example.administrator.jingdong.view.IClassifyView;

import java.util.List;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class ClassifyFragment extends BaseFragment implements IClassifyView,IClassify2View {
    private View view;
    private RecyclerView mRv1;
    private RecyclerView mRv2;
    private PresenterClassify presenterClassify;
    private Presenter2Classify presenter2Classifyl;
    private MyClassifyAdapter myClassifyAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.classifyf1;
    }

    @Override
    protected void initView(View view) {

        mRv1 = (RecyclerView) view.findViewById(R.id.rv1);
        mRv2 = (RecyclerView) view.findViewById(R.id.rv2);
    }

    @Override
    protected void initData() {
        presenterClassify=new PresenterClassify(this);

        presenterClassify.getData();
        presenter2Classifyl=new Presenter2Classify(this);
        presenter2Classifyl.getData(1);



    }

    @Override
    public void Yes(Object o) {

        ClassifyBean o1 = (ClassifyBean) o;
        final List<ClassifyBean.DataBean> data = o1.getData();
        if (data!=null){
            myClassifyAdapter = new MyClassifyAdapter(getActivity());
            myClassifyAdapter.setList(data);
            mRv1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            mRv1.setAdapter(myClassifyAdapter);
            myClassifyAdapter.setOnItemClickListener(new MyClassifyAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    presenter2Classifyl.getData(data.get(position).getCid());
                }
            });
        }




    }

    @Override
    public void No(String e) {

    }


    @Override
    public void onFailed(String msg) {


    }

    @Override
    public void onSuccess(Object o) {
        Classify2Bean o1 = (Classify2Bean) o;
        List<Classify2Bean.DataBean> data = o1.getData();

        MyClassify2Adapter myClassify2Adapter = new MyClassify2Adapter(getActivity());
        myClassify2Adapter.setList(data);
        mRv2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRv2.setAdapter(myClassify2Adapter);

    }
}
