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
import com.example.administrator.jingdong.bean.FenleishangpinBean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class MyFenleishangpinAdapter extends RecyclerView.Adapter<MyFenleishangpinAdapter.ViewHolder> {
private Context context;
private List<FenleishangpinBean.DataBean> data;

    public MyFenleishangpinAdapter(Context context, List<FenleishangpinBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }
    //条目点击监听
    private MyClassifyAdapter.OnItemClickListener onItemClickListener;
    //条目点击事件
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    //条目点击事件
    public void setOnItemClickListener(MyClassifyAdapter.OnItemClickListener onItemClickListener){

        this.onItemClickListener = onItemClickListener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.fenleishangpinitem,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tv.setText(data.get(position).getTitle());
//分割图片地址
        String images = data.get(position).getImages();

        String[] urls = images.split("\\|");

        Glide.with(context)
                .load(urls[0])
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //条目的点击事件
                int index = holder.getLayoutPosition();
                onItemClickListener.onItemClick(view,index);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.fenleishangpinimg);
            tv = itemView.findViewById(R.id.fenleishangpintv);
        }
    }

}
