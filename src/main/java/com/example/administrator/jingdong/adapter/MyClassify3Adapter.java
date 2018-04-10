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
import com.example.administrator.jingdong.bean.Classify2Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class MyClassify3Adapter extends RecyclerView.Adapter<MyClassify3Adapter.ViewHolder> {

    private Context context;
    private List<Classify2Bean.DataBean.ListBean> list;

    public MyClassify3Adapter(Context context) {
        this.context = context;
    }

    public void setList(List<Classify2Bean.DataBean.ListBean> list) {
        this.list = list;
        notifyDataSetChanged();
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
        View view= LayoutInflater.from(context).inflate(R.layout.classifyitem3,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getName());
        Glide.with(context)
                .load(list.get(position).getIcon())
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
        return list!=null?list.size():0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.classifytv3);
            img = itemView.findViewById(R.id.classifyimg1);
        }
    }
}
