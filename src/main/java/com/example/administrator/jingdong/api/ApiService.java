package com.example.administrator.jingdong.api;

import com.example.administrator.jingdong.bean.Classify2Bean;
import com.example.administrator.jingdong.bean.ClassifyBean;
import com.example.administrator.jingdong.bean.FenleishangpinBean;
import com.example.administrator.jingdong.bean.SpxiangpingBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public interface ApiService {

    @GET("product/getCatagory")
    Observable<ClassifyBean> getMeessg();

    @GET("product/getProductCatagory")
    Observable<Classify2Bean> getCefenlei(@Query("cid") int page);



    @GET("product/getProducts")
    Observable<FenleishangpinBean> getFenleiShangpin(@Query("pscid") int pscid);


    @GET("product/getProductDetail")
    Observable<SpxiangpingBean> getSpxiangping(@Query("pid") int pid);

}
