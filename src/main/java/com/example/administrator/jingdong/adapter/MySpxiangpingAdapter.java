package com.example.administrator.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.bean.SpxiangpingBean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class MySpxiangpingAdapter extends RecyclerView.Adapter<MySpxiangpingAdapter.ViewHolder>{

    private Context context;
    private List<SpxiangpingBean.DataBean> list;

    public MySpxiangpingAdapter(Context context, List<SpxiangpingBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.spxiangpingitem,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    holder.tv1.setText(list.get(position).getTitle());



    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tv1;
        private final TextView tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.spxiangpingimg);
            tv1 = itemView.findViewById(R.id.sptv1);
            tv2 = itemView.findViewById(R.id.sptv2);
        }
    }
}
