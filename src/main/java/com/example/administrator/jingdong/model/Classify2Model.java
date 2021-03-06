package com.example.administrator.jingdong.model;

import android.util.Log;

import com.example.administrator.jingdong.api.Api;
import com.example.administrator.jingdong.api.ApiService;
import com.example.administrator.jingdong.bean.Classify2Bean;
import com.example.administrator.jingdong.presenter.IPresenter2Classify;


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

public class Classify2Model implements IClassify2Model {
    @Override
    public void getData(int page, final IPresenter2Classify iPresenter2Classify) {

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
             Observable<Classify2Bean> cefenlei = apiService.getCefenlei(page);
             cefenlei.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Classify2Bean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                            iPresenter2Classify.onFailed(e.getMessage());
                        }

                        @Override
                        public void onNext(Classify2Bean classify2Bean) {

                            iPresenter2Classify.onSuccess(classify2Bean);
                        }
                    });


    }
}
