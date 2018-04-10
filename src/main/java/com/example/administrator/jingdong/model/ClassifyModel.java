package com.example.administrator.jingdong.model;

import android.util.Log;

import com.example.administrator.jingdong.api.Api;
import com.example.administrator.jingdong.api.ApiService;
import com.example.administrator.jingdong.bean.ClassifyBean;
import com.example.administrator.jingdong.presenter.IPresenterClassify;
import com.example.administrator.jingdong.utils.RetrofitUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class ClassifyModel implements IClassifyModel {
    @Override
    public void getData(final IPresenterClassify iPresenterClassify) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx", message);
            }
        });
        //日志级别
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(5000, java.util.concurrent.TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.fenlei).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient).build();

        ApiService apiService = retrofit.create(ApiService.class);
        Observable<ClassifyBean> observable = apiService.getMeessg();

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ClassifyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iPresenterClassify.No(e.getMessage());

                    }

                    @Override
                    public void onNext(ClassifyBean classifyBean) {
                        iPresenterClassify.Yes(classifyBean);
                    }
                });


    }
}
